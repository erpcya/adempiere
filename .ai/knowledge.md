# Knowledge Contract — adempiere

> Standard: `knowledge-contract-v1`. Authored from repository evidence on
> 2026-09-02, at `59557cc2`, without a release: this repository's first contract
> is written by hand because generating it from a release would mean creating a
> release for no other reason. Subsequent revisions come from
> `knowledge-on-release` when upstream is merged and tagged.

## 1. Identity

| Field | Value |
|---|---|
| Repository | `erpcya/adempiere` |
| Classification | `Base` |
| Entity type | `D` |
| Owner | ERP Consultores y Asociados |
| Upstream | `adempiere/adempiere` |
| Branch read | `feature/erpya/master` |
| Changes | `never` — see `organization/DR-0003` |

This is this installation's fork of the ADempiere community base, at 3.9.4.001.

**It carries no local source changes.** Compared against `adempiere/adempiere`
`master`, this branch is three commits ahead and zero behind, and all three are
merges — the file-level difference is empty. That is a fact worth stating plainly
in section 1, because the whole architecture depends on it: the value of this fork
is that it is *identical* to upstream and can therefore absorb upstream freely.

## 2. Responsibility

The base provides what every ADempiere installation has: the data dictionary, the
persistence layer and its generated models, document processing, accounting,
inventory, business partners, and the Swing and ZK clients that present them.

For this platform its responsibility is different from every other repository's:
**it is the evidence, not a destination.** Most functional questions — how an order
completes, when a payment allocates, which callout fires on a field — are
questions about code that lives here. An analysis that will not read this
repository cannot answer them.

## 3. Architecture

29 Gradle modules (`settings.gradle`). The ones that matter to routing:

| Module | Contains |
|---|---|
| `base/` | Models, processes, accounting, the dictionary — the bulk of business logic |
| `client/` | The Swing desktop client and its controllers |
| `zkwebui/` | The ZK web UI |
| `org.adempiere.*`, `org.eevolution.*`, `org.spin.*` | Functional extensions shipped with the base |
| `migration/` | Applied SQL migrations, by release |

Built with Gradle. The version comes from `ADEMPIERE_LIBRARY_VERSION`, defaulting
to `local-1.0.0`, and the published `base` artifact is what the libraries in this
installation compile against — `io.github.adempiere:base:3.9.4`.

## 4. Dependencies

Upstream `adempiere/adempiere`, merged by hand and tagged. Nothing in this
installation is a dependency of the base; the arrow points the other way.

## 5. Consumers

Everything. Directly:

- `erpcya/adempiere_patch`, `adempiere_patch_swing`, `adempiere_patch_zk` — the
  patches, which **shadow classes from this repository on the classpath**. This is
  the mechanism section 7 depends on.
- The libraries — `adempiere-pos-improvements`, `adempiere-dashboard-improvements`,
  `LVE`, `withholding-engine`, `adempiere-jwt-token`,
  `adempiere-business-processors`, `adempiere-payroll-multi-engine` — which compile
  against `io.github.adempiere:base:3.9.4`.

A change to a base class signature is a change to every one of them, and none of
them is built in this repository's CI. That is the risk in section 9.

## 6. Allowed changes

**Only this repository describing itself:**

- `.ai/**` — this contract, the marker, decision records
- `.github/workflows/**` — the platform's actions

Merging upstream and tagging a release is a human activity and is not a change
this platform proposes.

## 7. Prohibited changes

**Every change to source.** Not minimized, not justified case by case, not
permitted for a sufficiently important fix: none. See `organization/DR-0003`.

The reason is arithmetic rather than principle. A line changed here is a line
somebody reconciles by hand on every future upstream merge, forever, and the
person paying that cost is not the person who made the change. Today the
file-level diff against upstream is empty (§1) and merges are therefore cheap.
Every local edit is a permanent tax on that.

**What to do instead.** Copy the file into the patch that shadows it and edit the
copy. The patch is chosen by where the file lives here — `client/` to
`adempiere_patch_swing`, `zkwebui/` to `adempiere_patch_zk`, everything else to
`adempiere_patch` — as declared in `.ai/repository.yml`. The copy records the
commit it was taken at.

## 8. Architectural rules

- A class in a patch with the same fully-qualified name as one here **shadows it
  at runtime**. That is the override mechanism, and it is why prohibiting changes
  here costs nothing functionally.
- Generated classes — `X_*`, `I_*`, generated abstract process classes — are
  produced from the dictionary and are never hand-edited, here or in a copy.
- An applied migration is never edited. A correction is a new migration.
- An extracted copy must record its source commit. Without it, no later process
  can determine whether this repository has moved underneath the copy.

## 9. Risks

**A stale override is invisible.** This is the risk the whole arrangement creates
and the one worth stating first. When a file copied into a patch is later fixed
here, the copy keeps the old behaviour: it compiles, it runs, and nothing reports
it. The recorded source commit is the only thing that makes the question
answerable, and answering it is work `release-impact` must do on each release of
this repository.

**No consumer is built here.** The libraries and patches that compile against the
base are built in their own repositories. A signature change that breaks seven
downstream repositories passes this repository's CI.

**The fork is two years behind in wall-clock time.** The last merge from upstream
is 2023-12-11. This is a fact, not a defect — 3.9.4.001 is what runs in production
— but an analysis should not assume a fix present in upstream today is present
here.

## 10. Current state

At `59557cc2`, `feature/erpya/master`, three merge commits ahead of upstream
`master`, no file-level divergence. No release has been published from this fork,
so this contract has no `knowledge-on-release` predecessor.

## 11. UNKNOWN

- **Whether any patch already overrides a given base file, and at which commit.**
  Nothing has recorded that until now. The first extractions will establish it;
  existing overrides in the three patch repositories predate the rule and carry no
  source-commit header. **Whether those existing copies are current is unknown and
  cannot be derived** — they must be checked one by one, or accepted as unverified.
- **The upstream merge cadence.** Two years since the last merge is observable;
  whether that is intentional is not recorded.
- **Which modules are actually deployed.** 29 modules are declared; which ones this
  installation ships is not stated anywhere in this repository.
