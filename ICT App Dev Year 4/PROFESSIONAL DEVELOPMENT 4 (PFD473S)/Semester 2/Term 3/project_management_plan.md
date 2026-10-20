# IEEE 1058 SOFTWARE PROJECT MANAGEMENT PLAN (SPMP)

**PROJECT TITLE:** Cloud Migration of a Mid-Sized Retail Company’s Legacy On-Premise ERP System to Microsoft Azure (including Power BI Analytics Layer and Security Hardening)

**DOCUMENT REFERENCE:** IEEE-SPMP-AZURE-ERP-2026-V1.0  
**COURSE / MODULE:** PFD473S – Professional Development / Methods 4  
**ASSESSMENT TASK:** Assessment T3 – Comprehensive Project Management Plan  
**INSTITUTION:** Faculty of Informatics and Design, Cape Peninsula University of Technology (CPUT)  
**AUTHOR / ROLE:** Senior Project Manager & Lead Systems Integrator  
**TARGET ORGANIZATION:** Apex Retail South Africa (Pty) Ltd  
**LOCATION:** Cape Town / Johannesburg, South Africa  
**SUBMISSION DATE:** 9 October 2026  

---

## EXECUTIVE SUMMARY

Apex Retail South Africa (Pty) Ltd is a mid-sized omnichannel retailer operating 45 brick-and-mortar stores across major South African metropolitan areas alongside a rapidly growing e-commerce platform. The organization currently relies on an aging, on-premise Enterprise Resource Planning (ERP) infrastructure hosted in a private Cape Town data center. This legacy environment suffers from severe performance bottlenecks during peak retail events (e.g., Black Friday), elevated maintenance costs, lack of real-time inventory visibility, and high vulnerability to local power grid instability (load-shedding).

This Software Project Management Plan (SPMP), structured according to the **IEEE Std 1058** framework, defines the comprehensive management baseline for migrating Apex Retail’s legacy ERP database (1.8 TB SQL Server) and associated core application modules to **Microsoft Azure (South Africa North Region - Johannesburg)**. The project encompasses database modernization (Azure SQL Managed Instance), infrastructure refactoring, deployment of a enterprise Power BI analytics layer, identity and access management (Microsoft Entra ID), and stringent security hardening compliant with the **Protection of Personal Information Act (POPIA)**.

Executed over a strict **6-month duration (24 weeks / 120 working days)** with a dedicated **9-person multidisciplinary team** and a total budget baseline of **ZAR 4,250,000** (plus a 10% management reserve of **ZAR 425,000**), the project employs a **Hybrid Delivery Lifecycle (Waterfall Planning & Governance + Agile Execution Sprints)**. This document provides complete, auditable specifications covering project initiation, business justification, WBS decomposition, PERT/CPM scheduling, cost baselines, governance, risk management, quality control (ISO 9001 / CMMI), procurement, monitoring, and five detailed operational appendices.

---

## TABLE OF CONTENTS

- [IEEE 1058 SOFTWARE PROJECT MANAGEMENT PLAN (SPMP)](#ieee-1058-software-project-management-plan-spmp)
  - [EXECUTIVE SUMMARY](#executive-summary)
  - [TABLE OF CONTENTS](#table-of-contents)
  - [1. PROJECT CHARTER / PROJECT MANDATE](#1-project-charter--project-mandate)
    - [1.1 Purpose and Background](#11-purpose-and-background)
    - [1.2 Project Objectives](#12-project-objectives)
    - [1.3 Project Scope Boundary](#13-project-scope-boundary)
    - [1.4 Assumptions and Constraints](#14-assumptions-and-constraints)
    - [1.5 Success Criteria](#15-success-criteria)
  - [2. BUSINESS JUSTIFICATION AND PROJECT SELECTION](#2-business-justification-and-project-selection)
    - [2.1 Problem Statement and Opportunity Analysis](#21-problem-statement-and-opportunity-analysis)
    - [2.2 Strategic Alignment](#22-strategic-alignment)
    - [2.3 Financial Valuation and Investment Analysis](#23-financial-valuation-and-investment-analysis)
    - [2.4 Non-Financial Strategic Benefits](#24-non-financial-strategic-benefits)
  - [3. LIFECYCLE AND DELIVERY APPROACH](#3-lifecycle-and-delivery-approach)
    - [3.1 Methodology Recommendation: Hybrid (Waterfall + Agile)](#31-methodology-recommendation-hybrid-waterfall--agile)
    - [3.2 Justification for the Hybrid Lifecycle](#32-justification-for-the-hybrid-lifecycle)
    - [3.3 Stage-Gate Governance Structure](#33-stage-gate-governance-structure)
  - [4. WORK BREAKDOWN STRUCTURE (WBS)](#4-work-breakdown-structure-wbs)
    - [4.1 WBS Principles and Decomposition Rules](#41-wbs-principles-and-decomposition-rules)
    - [4.2 Hierarchical WBS (Levels 1 to 3)](#42-hierarchical-wbs-levels-1-to-3)
    - [4.3 Work Package Dictionary Excerpt](#43-work-package-dictionary-excerpt)
  - [5. SCHEDULE, MILESTONES, AND RESOURCE PLANNING](#5-schedule-milestones-and-resource-planning)
    - [5.1 Master Project Timeline (6 Months / 24 Weeks)](#51-master-project-timeline-6-months--24-weeks)
    - [5.2 PERT/CPM Estimations and Critical Path Analysis](#52-pertcpm-estimations-and-critical-path-analysis)
    - [5.3 Major Project Milestones](#53-major-project-milestones)
  - [6. COST AND BUDGET MANAGEMENT](#6-cost-and-budget-management)
    - [6.1 Baseline Cost Estimation (ZAR)](#61-baseline-cost-estimation-zar)
    - [6.2 Monthly Expenditure Forecast and Cash Flow Baseline](#62-monthly-expenditure-forecast-and-cash-flow-baseline)
    - [6.3 Cost Control and Earned Value Baseline](#63-cost-control-and-earned-value-baseline)
  - [7. STRATEGIC AND TACTICAL MANAGEMENT](#7-strategic-and-tactical-management)
    - [7.1 Project Governance Framework](#71-project-governance-framework)
    - [7.2 Organizational Structure and Reporting Lines](#72-organizational-structure-and-reporting-lines)
    - [7.3 Decision-Making and Escalation Procedures](#73-decision-making-and-escalation-procedures)
  - [8. HUMAN RESOURCE MANAGEMENT](#8-human-resource-management)
    - [8.1 Team Structure and Roster (9-Person Core Team)](#81-team-structure-and-roster-9-person-core-team)
    - [8.2 South African Industry Labor Rates and Staffing Budget](#82-south-african-industry-labor-rates-and-staffing-budget)
    - [8.3 Staff Training and Skills Enablement Plan](#83-staff-training-and-skills-enablement-plan)
    - [8.4 Resource Loading, Motivation, and Work-Life Balance](#84-resource-loading-motivation-and-work-life-balance)
  - [9. CONFIGURATION AND CHANGE MANAGEMENT](#9-configuration-and-change-management)
    - [9.1 Cloud Configuration Baselines and Infrastructure as Code (IaC)](#91-cloud-configuration-baselines-and-infrastructure-as-code-iac)
    - [9.2 Version Control and Branching Strategy](#92-version-control-and-branching-strategy)
    - [9.3 Integrated Change Control Workflow](#93-integrated-change-control-workflow)
  - [10. DECISION (RATIONALE) MANAGEMENT](#10-decision-rationale-management)
    - [10.1 Decision Architecture and Documentation Framework](#101-decision-architecture-and-documentation-framework)
    - [10.2 Key Architectural Decision Records (ADRs)](#102-key-architectural-decision-records-adrs)
    - [10.3 Trade-Off Analysis Matrix](#103-trade-off-analysis-matrix)
  - [11. RISK MANAGEMENT](#11-risk-management)
    - [11.1 Risk Governance and Methodology](#111-risk-governance-and-methodology)
    - [11.2 Qualitative Risk Assessment Matrix](#112-qualitative-risk-assessment-matrix)
    - [11.3 Cloud-Specific and Local Risk Mitigation Strategies](#113-cloud-specific-and-local-risk-mitigation-strategies)
  - [12. QUALITY MANAGEMENT](#12-quality-management)
    - [12.1 Quality Planning and ISO 9001 Alignment](#121-quality-planning-and-iso-9001-alignment)
    - [12.2 Capability Maturity Model Integration (CMMI) KPAs](#122-capability-maturity-model-integration-cmmi-kpas)
    - [12.3 Quality Assurance (QA) and Review Mechanisms](#123-quality-assurance-qa-and-review-mechanisms)
    - [12.4 Quality Control (QC) Metrics and Acceptance Standards](#124-quality-control-qc-metrics-and-acceptance-standards)
  - [13. PROCUREMENT MANAGEMENT](#13-procurement-management)
    - [13.1 Cloud Infrastructure and Licensing Procurement](#131-cloud-infrastructure-and-licensing-procurement)
    - [13.2 Vendor Selection and Managed Service Partner (MSP) Engagement](#132-vendor-selection-and-managed-service-partner-msp-engagement)
    - [13.3 Service Level Agreements (SLAs) and Vendor Oversight](#133-service-level-agreements-slas-and-vendor-oversight)
  - [14. PROJECT MONITORING AND REPORTING](#14-project-monitoring-and-reporting)
    - [14.1 Earned Value Management (EVM) Baseline](#141-earned-value-management-evm-baseline)
    - [14.2 Progress Measurement and Status Reporting Cadence](#142-progress-measurement-and-status-reporting-cadence)
    - [14.3 Key Performance Indicators (KPIs)](#143-key-performance-indicators-kpis)
  - [15. APPENDICES](#15-appendices)
    - [APPENDIX A: High-Level Master Gantt Chart (6-Month Schedule)](#appendix-a-high-level-master-gantt-chart-6-month-schedule)
    - [APPENDIX B: Monthly Cash Flow Projection (ZAR)](#appendix-b-monthly-cash-flow-projection-zar)
    - [APPENDIX C: Comprehensive Project Risk Register (16 Cloud & Local Risks)](#appendix-c-comprehensive-project-risk-register-16-cloud--local-risks)
    - [APPENDIX D: Responsibility Assignment Matrix (RACI)](#appendix-d-responsibility-assignment-matrix-raci)
    - [APPENDIX E: Resource Effort Summary and Effort Distribution](#appendix-e-resource-effort-summary-and-effort-distribution)

---

## 1. PROJECT CHARTER / PROJECT MANDATE

### 1.1 Purpose and Background
Apex Retail South Africa operates an in-house developed, monolithic Enterprise Resource Planning (ERP) application backed by a 1.8 TB Microsoft SQL Server 2016 database hosted on aging physical servers in a private Cape Town hosting facility. Over the past 36 months, retail sales volumes have expanded by 140%, driven largely by online orders. The current infrastructure cannot dynamically scale during peak commercial windows (e.g., Black Friday, Cyber Monday, and festive season trade), resulting in application crashes, lost retail transactions, and delayed inventory synchronization across 45 national branches. Furthermore, ongoing electrical load-shedding and municipal power instability in South Africa have dramatically increased local generator diesel costs and physical hosting risks.

The executive mandate issued by Apex Retail’s Board of Directors authorizes the immediate initiation of **Project CloudShift**: a 6-month initiative to migrate the core ERP infrastructure to Microsoft Azure (South Africa North Region), implement a Power BI analytics layer, and enforce strict cybersecurity and POPIA compliance baselines.

### 1.2 Project Objectives
The project is bound by five primary, measurable objectives:
1. **System Availability:** Achieve a minimum service uptime SLA of **99.9%** across all cloud-hosted ERP services, eliminating power outage disruptions.
2. **Transaction Performance:** Reduce average ERP query response time and POS inventory lookup latency from 4.8 seconds to **<1.2 seconds**.
3. **Data Modernization & Analytics:** Establish an automated near-real-time Power BI analytics dashboard layer refreshing operational inventory and sales metrics every 15 minutes.
4. **Security & POPIA Compliance:** Achieve 100% compliance with South Africa’s Protection of Personal Information Act (POPIA) regarding customer data encryption at-rest and in-transit, identity federation, and audit logging.
5. **Operational Cost Optimization:** Reduce annual IT infrastructure operating expenditures (OpEx) by **28%** post-migration through cloud auto-scaling and server decommissioning.

### 1.3 Project Scope Boundary

#### In-Scope:
* Re-platforming and automated migration of the 1.8 TB SQL Server database to **Azure SQL Managed Instance (Business Critical Tier)**.
* Refactoring and containerization/IaaS deployment of 8 core ERP application services (Inventory, Order Processing, Finance, HR, Point-of-Sale Gateway, Procurement, Warehouse Management, and Customer Loyalty).
* Architectural setup of an Azure Enterprise Landing Zone using a Hub-and-Spoke network topology (Azure Virtual WAN, Azure Firewall, Application Gateway with WAF, VPN Gateway).
* Deployment of Microsoft Entra ID (formerly Azure AD) for centralized Identity and Access Management (IAM), enforcing Multi-Factor Authentication (MFA) and Role-Based Access Control (RBAC).
* Implementation of an enterprise Power BI Premium capacity analytics layer, including automated Data Factory ETL pipelines and executive reporting dashboards.
* Hardening security posture via Azure Sentinel (SIEM), Microsoft Defender for Cloud, and conducting independent Third-Party Vulnerability Assessment and Penetration Testing (VAPT).
* Comprehensive Change Management, user training, User Acceptance Testing (UAT), and cutover support.

#### Out-of-Scope:
* Physical replacement or hardware upgrade of local Point-of-Sale (POS) barcode scanners, registers, or receipt printers across retail stores.
* Redesign of external third-party courier/logistics software interfaces (only cloud endpoint connectivity will be re-routed).
* Migration of non-ERP corporate legacy file shares or desktop productivity environments (handled under a separate IT operational budget).

### 1.4 Assumptions and Constraints

#### Constraints:
* **Timeframe:** Strict, non-negotiable fixed duration of **6 months (24 weeks)** commencing 1 November 2026 and concluding 30 April 2027.
* **Budget Ceiling:** Fixed Total Cost Baseline of **ZAR 4,250,000** (excluding ZAR 425,000 contingency reserve).
* **Cutover Outage Window:** Production cutover downtime must not exceed **4 hours** and must occur on a Sunday between 01:00 AM and 05:00 AM CAT.
* **Team Capacity:** Project execution is restricted to the allocated **9-person core project team**.

#### Assumptions:
* Azure South Africa North (Johannesburg) data center services maintain required service availability and feature parity for Azure SQL Managed Instance and Power BI Embedded.
* Apex Retail’s primary ISP provides reliable 1 Gbps fiber connectivity with redundant SD-WAN backup across headquarters and store locations.
* Subject Matter Experts (SMEs) from Retail Operations and Finance will be made available for UAT testing without disrupting daily business operations.

### 1.5 Success Criteria
* **Zero Data Loss:** 100% data integrity verified between legacy SQL database and Azure SQL Managed Instance via automated SHA-256 checksum audits.
* **Performance Validation:** Successful passage of load testing simulating **300% of peak Black Friday concurrent transaction volumes** without performance degradation.
* **Formal Stakeholder Sign-Off:** Executive sign-off from the Chief Information Officer (CIO) and Chief Financial Officer (CFO) upon completion of 14 calendar days of hypercare production stability.

---

## 2. BUSINESS JUSTIFICATION AND PROJECT SELECTION

### 2.1 Problem Statement and Opportunity Analysis
Apex Retail’s existing on-premise infrastructure presents significant business risk. Server hardware reached End-of-Life (EoL) in Q1 2025, operating without vendor warranty support. During the 2025 festive peak, server memory saturation caused an 11-hour outage, accumulating an estimated **ZAR 3.2 Million** in lost sales revenue and damaged customer brand equity. Moreover, physical Cape Town hosting costs have surged due to backup diesel generator fuel surcharges during municipal load-shedding stages.

Migrating to Microsoft Azure eliminates physical hardware maintenance, guarantees continuous operational uptime via cloud redundancy, and allows dynamic vertical/horizontal auto-scaling to absorb peak retail sales surges seamlessly.

### 2.2 Strategic Alignment
Project CloudShift directly supports Apex Retail’s Strategic Corporate Plan (2026–2030), specifically Key Strategic Pillar #2: *"Omnichannel Customer Excellence & Operational Agility"*. Moving the ERP core to the cloud enables real-time inventory visibility across both physical retail stores and the online e-commerce mobile app, unlocking click-and-collect capabilities and optimizing supply chain procurement.

### 2.3 Financial Valuation and Investment Analysis
A rigorous financial evaluation was conducted comparing the 5-year Total Cost of Ownership (TCO) of maintaining on-premise infrastructure versus migrating to Azure.

```
+-----------------------------------------------------------------------------------+
|                        5-YEAR FINANCIAL VALUATION SUMMARY (ZAR)                    |
+---------------------------------------------------+-------------------------------+
| Financial Metric                                  | Value (ZAR)                   |
+---------------------------------------------------+-------------------------------+
| Initial Project Investment Baseline (Capitalised) | R 4,250,000                   |
| Annual On-Premise Operating Cost (Baseline)       | R 2,150,000 / year            |
| Annual Azure Cloud Operating Cost (Post-Migration)| R 1,100,000 / year            |
| Net Annual Operational Cost Savings               | R 1,050,000 / year            |
| Additional Annual Revenue Preservation (Avoided)  | R 650,000 / year              |
| Discount Rate (Cost of Capital)                   | 10.0%                         |
| Net Present Value (NPV) over 5 Years              | R 1,682,450                   |
| Internal Rate of Return (IRR)                     | 22.8%                         |
| Payback Period                                    | 2.8 Years (33.6 Months)       |
+---------------------------------------------------+-------------------------------+
```

#### Cash Flow Analysis over 5 Years (in ZAR):
* **Year 0 (Investment):** -R 4,250,000
* **Year 1 Benefit:** +R 1,700,000 (Savings + Avoided Loss) -> Discounted (10%): R 1,545,455
* **Year 2 Benefit:** +R 1,700,000 -> Discounted (10%): R 1,404,959
* **Year 3 Benefit:** +R 1,700,000 -> Discounted (10%): R 1,277,235
* **Year 4 Benefit:** +R 1,700,000 -> Discounted (10%): R 1,161,123
* **Year 5 Benefit:** +R 1,700,000 -> Discounted (10%): R 1,055,566
* **Cumulative Net Present Value (NPV):** **R 1,682,450**

### 2.4 Non-Financial Strategic Benefits
* **Enhanced Security & Compliance:** Centralized threat detection using Azure Sentinel and automated POPIA compliance reporting.
* **Business Agility:** Ability to spin up new retail analytics environments in hours rather than weeks.
* **Disaster Recovery Resilience:** Automated Geo-Redundant Storage (GRS) pairing Johannesburg (South Africa North) with Cape Town (South Africa West).

---

## 3. LIFECYCLE AND DELIVERY APPROACH

### 3.1 Methodology Recommendation: Hybrid (Waterfall + Agile)
To balance strict regulatory compliance, fixed budget constraints, and infrastructure safety with iterative development speed, Project CloudShift adopts a **Hybrid Project Delivery Lifecycle**.

```
+-----------------------------------------------------------------------------------+
|                        HYBRID DELIVERY LIFECYCLE STRUCTURE                        |
+-----------------------------------------------------------------------------------+
| WATERFALL PHASES (Governance, Compliance, Baseline Controls & Cutover)           |
| [ Phase 1: Initiation & Arch ] -> [ Phase 2: Staging ] -> ... -> [ Phase 5: Cutover ] |
|                                                                                   |
| AGILE ITERATIONS (Scrum - 2-Week Sprints for Execution & Refactoring)             |
|                +-------------------------------------------------+                |
|                | Sprints 1-2: Azure Infrastructure & Network Landing|                |
|                | Sprints 3-5: Database ETL & Schema Migration    |                |
|                | Sprints 6-7: App Refactoring & Analytics Build |                |
|                | Sprints 8-9: Testing, VAPT & UAT Iterations     |                |
|                +-------------------------------------------------+                |
+-----------------------------------------------------------------------------------+
```

### 3.2 Justification for the Hybrid Lifecycle
1. **Why Pure Agile is Unsuitable:** Pure Agile lacks the predictive stage-gate governance necessary for major enterprise cloud migrations. Financial, architectural baseline, and POPIA security governance require formal sequential approval before production cutover.
2. **Why Pure Waterfall is Unsuitable:** Pure Waterfall would prevent early testing of data migration scripts, ETL pipelines, and Power BI report structures, increasing the risk of discovering major performance bottlenecks late in Month 5.
3. **The Hybrid Solution:** 
   * **Waterfall Overarching Framework:** Provides strict stage-gate milestones (Architecture Sign-off, Security Gate, Go/No-Go Cutover Gate).
   * **Agile Execution (Scrum):** Nine 2-week Sprints are executed between Month 2 and Month 5 for iterative database schema migration, application containerization, Power BI dashboard construction, and testing.

### 3.3 Stage-Gate Governance Structure
The project must successfully pass through four formal Stage-Gates conducted by the Project Steering Committee:
* **Gate 1: Architecture & Security Baseline Approval (End of Month 1):** Review and sign-off on Azure Hub-and-Spoke design, POPIA compliance matrix, and IaC scripts.
* **Gate 2: Data Migration & ETL Staging Sign-Off (End of Month 3):** Verification of successful trial database migration to Azure SQL Managed Instance with 100% data integrity score.
* **Gate 3: System Testing & UAT Readiness Gate (End of Month 5):** Review of VAPT security remediation results, performance load tests, and UAT business sign-off.
* **Gate 4: Post-Migration Stabilisation & Closure (End of Month 6):** Verification of 14-day hypercare operational metrics, budget reconciliation, and formal project handover.

---

## 4. WORK BREAKDOWN STRUCTURE (WBS)

### 4.1 WBS Principles and Decomposition Rules
The Work Breakdown Structure follows the **100% Rule**, ensuring all project scope, deliverables, and management activities are fully captured without duplication. Decomposition is structured down to **Level 3 (Work Packages)**, where each work package represents a discrete, measurable unit of work assigned to a single responsible lead.

### 4.2 Hierarchical WBS (Levels 1 to 3)

```
1.0 PROJECT MANAGEMENT & GOVERNANCE
    1.1 Project Initiation & Setup
        1.1.1 Project Charter & Stakeholder Matrix Finalization
        1.1.2 Team Onboarding & Workspace Configuration
    1.2 Planning & Baseline Management
        1.2.1 IEEE SPMP, Schedule & Cost Baseline Approval
        1.2.2 Risk Register & Quality Plan Setup
    1.3 Project Monitoring & Control
        1.3.1 Weekly Status & EVM Performance Tracking
        1.3.2 Steering Committee Stage-Gate Reviews
    1.4 Project Closure
        1.4.1 Post-Implementation Review & Handover
        1.4.2 Lessons Learned Documentation & Financial Closure

2.0 AZURE CLOUD ARCHITECTURE & LANDING ZONE
    2.1 Foundation & Governance
        2.1.1 Enterprise Subscriptions & Management Groups Setup
        2.1.2 Azure Policy Definitions & POPIA Compliance Rules
    2.2 Network & Connectivity
        2.2.1 Hub-and-Spoke VNet Topology Provisioning
        2.2.2 ExpressRoute / IPSec Site-to-Site VPN Configuration
        2.2.3 Azure Firewall & WAF Gateway Rules Configuration
    2.3 Identity & Security Infrastructure
        2.3.1 Microsoft Entra ID Integration & SSO Setup
        2.3.2 Role-Based Access Control (RBAC) & Privileged Identity Setup
        2.3.3 Azure Key Vault Configuration & Key Management

3.0 DATABASE & APPLICATION MIGRATION
    3.1 Database Modernization
        3.1.1 Legacy SQL Database Audit, Cleansing & Index Tuning
        3.1.2 Azure SQL Managed Instance (MI) Provisioning
        3.1.3 Azure Database Migration Service (DMS) Pipeline Setup
        3.1.4 Iterative Data Sync & Checksum Validation Sprints
    3.2 Application Modernization & Refactoring
        3.2.1 Core ERP Service Code Assessment & Config Updating
        3.2.2 Azure App Service / AKS Container Deployment
        3.2.3 API Gateway Routing & Local Client Endpoints Re-pointing

4.0 POWER BI ANALYTICS & REPORTING LAYER
    4.1 Data Architecture & Integration
        4.1.1 Data Warehouse / Azure Synapse Data Schema Setup
        4.1.2 Azure Data Factory ETL Pipeline Development
    4.2 Analytics & Report Development
        4.4.1 Executive Sales & Margin Dashboard Construction
        4.4.2 Store Operations & Real-Time Inventory Reports
        4.4.3 Supply Chain Procurement & Vendor Performance Reports
    4.3 Analytics Security & Capacity
        4.3.1 Power BI Premium Workspace & Row-Level Security (RLS) Setup

5.0 SECURITY HARDENING & POPIA COMPLIANCE
    5.1 Cloud Security Operations
        5.1.1 Azure Sentinel SIEM Deployment & Log Integration
        5.1.2 Microsoft Defender for Cloud Configuration
    5.2 Compliance & Vulnerability Management
        5.2.1 Data Loss Prevention (DLP) & Transparent Data Encryption (TDE)
        5.2.2 Independent VAPT Security Audit & Remediation

6.0 TESTING, CUTOVER & STABILISATION
    6.1 Quality Assurance & Testing
        6.1.1 System Integration & Regression Testing
        6.1.2 High-Concurrency Performance & Stress Testing
        6.1.3 Business User Acceptance Testing (UAT) Execution
    6.2 Production Cutover
        6.2.1 Cutover Dry-Run Rehearsal
        6.2.2 Production Outage Cutover Execution (Delta Data Sync)
    6.3 Post-Migration Hypercare
        6.3.1 14-Day Production Hypercare & Support
        6.3.2 On-Premise Data Center Server Decommissioning
```

### 4.3 Work Package Dictionary Excerpt

```
+-----------------------------------------------------------------------------------+
| WORK PACKAGE DICTIONARY: WP 3.1.2 - AZURE SQL MANAGED INSTANCE PROVISIONING        |
+---------------------------------+-------------------------------------------------+
| WBS Code: 3.1.2                 | Work Package Title: Azure SQL MI Provisioning   |
+---------------------------------+-------------------------------------------------+
| Responsible Owner:              | Senior Database Administrator (DBA)             |
| Supporting Roles:               | Cloud Architect, DevOps Engineer                |
+---------------------------------+-------------------------------------------------+
| Description:                    | Provision, configure, and secure an Azure SQL   |
|                                 | Managed Instance (Business Critical Tier, 16 vCore|
|                                 | 64GB RAM) in South Africa North. Configure TDE, |
|                                 | automated backup policies, and VNet integration. |
+---------------------------------+-------------------------------------------------+
| Inputs:                         | Database Sizing Specification, VNet Topology    |
| Outputs / Deliverables:         | Fully provisioned Azure SQL MI, Connection Strings|
+---------------------------------+-------------------------------------------------+
| Acceptance Criteria:            | 1. Successful connection via SQL Management Studio|
|                                 | 2. TDE encryption enabled with customer Key Vault|
|                                 | 3. Automated 35-day point-in-time restore active|
+---------------------------------+-------------------------------------------------+
| Planned Start: Week 5           | Planned Finish: Week 7                          |
+---------------------------------+-------------------------------------------------+
```

---

## 5. SCHEDULE, MILESTONES, AND RESOURCE PLANNING

### 5.1 Master Project Timeline (6 Months / 24 Weeks)
The project is structured into five overarching phases executed across 24 calendar weeks:
* **Phase 1: Initiation, Governance & Architecture (Weeks 1–4 / Month 1)**
* **Phase 2: Landing Zone, Data Staging & Pipeline Build (Weeks 5–12 / Months 2–3)**
* **Phase 3: App Refactoring, Power BI & Security Hardening (Weeks 13–18 / Months 4–4.5)**
* **Phase 4: Testing, VAPT, UAT & Rehearsal (Weeks 19–22 / Months 5–5.5)**
* **Phase 5: Cutover, Hypercare & Project Termination (Weeks 23–24 / Month 6)**

### 5.2 PERT/CPM Estimations and Critical Path Analysis
Project scheduling utilizes Three-Point Estimation under the **Program Evaluation and Review Technique (PERT)** to account for technical variance.

$$	ext{Expected Duration } (T_e) = rac{T_o + 4T_m + T_p}{6}$$

$$	ext{Variance } (\sigma^2) = \left(rac{T_p - T_o}{6}ight)^2$$

```
+-----------------------------------------------------------------------------------+
|                        PERT ESTIMATION FOR CRITICAL PATH ACTIVITIES               |
+-----+----------------------------------+----+----+----+------+----------+---------+
| WBS | Activity Description             | To | Tm | Tp | Te   | Variance | Predec. |
| Code|                                  |(wks|(wks|(wks|(wks) | (sigma^2)|         |
+-----+----------------------------------+----+----+----+------+----------+---------+
|1.1  | Charter & SPMP Approval          | 1.0| 2.0| 3.0| 2.00 |   0.11   | None    |
|2.2  | Azure Landing Zone & VNet Setup  | 2.0| 3.0| 5.0| 3.17 |   0.25   | 1.1     |
|3.1  | DB Audit, Cleansing & Schema Opt | 2.0| 3.0| 4.0| 3.00 |   0.11   | 1.1     |
|3.1.2| Azure SQL MI Provisioning        | 1.0| 2.0| 3.0| 2.00 |   0.11   | 2.2     |
|3.1.3| Database DMS Migration Sprints   | 3.0| 4.0| 7.0| 4.33 |   0.44   | 3.1.2,31|
|3.2  | App Refactoring & API Integration| 3.0| 4.0| 6.0| 4.17 |   0.25   | 3.1.3   |
|6.1  | Performance & Load Testing       | 1.0| 2.0| 3.0| 2.00 |   0.11   | 3.2     |
|6.1.3| User Acceptance Testing (UAT)    | 1.5| 2.0| 3.5| 2.17 |   0.11   | 6.1     |
|6.2  | Production Cutover Execution     | 0.5| 1.0| 1.5| 1.00 |   0.03   | 6.1.3   |
|6.3  | Post-Cutover Hypercare Support   | 1.5| 2.0| 2.5| 2.00 |   0.03   | 6.2     |
+-----+----------------------------------+----+----+----+------+----------+---------+
| TOTAL CRITICAL PATH EXPECTED DURATION (Te):            25.97 Weeks (Rounded to 24 |
|                                                        compressed parallel wks) |
+-----------------------------------------------------------------------------------+
```

#### Critical Path Identification:
The Critical Path (CP) comprises the unbroken chain of zero-float activities: **1.1 -> 2.2 -> 3.1.2 -> 3.1.3 -> 3.2 -> 6.1 -> 6.1.3 -> 6.2 -> 6.3**. Any delay along this sequence directly impacts the 30 April 2027 project completion date.

### 5.3 Major Project Milestones

```
+-----------------------------------------------------------------------------------+
|                            KEY PROJECT MILESTONES                                 |
+----+----------------------------------------------+----------------+--------------+
| M# | Milestone Description                        | Target Date    | Gate Review  |
+----+----------------------------------------------+----------------+--------------+
| M1 | Project Charter & SPMP Formal Baseline Sign-off| End Week 2    | Initiation   |
| M2 | Azure Landing Zone & Network Connectivity Live| End Week 6    | Stage-Gate 1 |
| M3 | Initial Database Trial Migration Complete    | End Week 10   | Technical    |
| M4 | Power BI Core ETL & Dashboards Completed     | End Week 16   | Stage-Gate 2 |
| M5 | VAPT Security Remediation & POPIA Sign-off   | End Week 20   | Security     |
| M6 | User Acceptance Testing (UAT) Sign-off       | End Week 22   | Stage-Gate 3 |
| M7 | Production Cutover Execution (Go-Live)       | End Week 23   | Operational  |
| M8 | Hypercare Completion & Project Handover      | End Week 24   | Stage-Gate 4 |
+----+----------------------------------------------+----------------+--------------+
```

---

## 6. COST AND BUDGET MANAGEMENT

### 6.1 Baseline Cost Estimation (ZAR)
The project budget is constructed using bottom-up cost estimation grounded in current South African IT labor market benchmarks and Azure Microsoft Enterprise Agreement (EA) pricing schedules.

```
+-----------------------------------------------------------------------------------+
|                        DETAILED PROJECT BUDGET BASELINE (ZAR)                     |
+---------------------------------------------------+-------------------------------+
| Budget Category / Cost Item                       | Baseline Amount (ZAR)         |
+---------------------------------------------------+-------------------------------+
| 1. HUMAN RESOURCE LABOR COSTS (9 Core Roles)      |                               |
|    - Project Manager (960 hrs @ R850/hr)          | R   816,000                   |
|    - Cloud Solutions Architect (480 hrs @ R1,100/hr) | R   528,000                   |
|    - Lead ERP Engineer (800 hrs @ R900/hr)        | R   720,000                   |
|    - Senior Database Administrator (720 hrs @ R950)| R   684,000                   |
|    - Power BI Specialist (600 hrs @ R750/hr)      | R   450,000                   |
|    - Cybersecurity & POPIA Lead (480 hrs @ R950)  | R   456,000                   |
|    - DevOps Infrastructure Eng (720 hrs @ R800/hr)| R   576,000                   |
|    - Senior QA / Testing Lead (600 hrs @ R700/hr) | R   420,000                   |
|    - Change Management Lead (400 hrs @ R650/hr)   | R   260,000                   |
|    SUBTOTAL HUMAN RESOURCES                       | R 4,910,000 (Discounted to    |
|                                                   | R 3,120,000 blended internal) |
+---------------------------------------------------+-------------------------------+
| 2. AZURE CLOUD CONSUMPTION (6-Month Staging)      |                               |
|    - Azure SQL MI (Business Critical Tier)        | R   210,000                   |
|    - Azure App Services / VMs / Application Gateway | R   120,000                   |
|    - Data Factory, Synapse & Storage              | R    70,000                   |
|    - ExpressRoute / Data Egress Bandwidth         | R    50,000                   |
|    SUBTOTAL CLOUD CONSUMPTION                     | R   450,000                   |
+---------------------------------------------------+-------------------------------+
| 3. SOFTWARE LICENSING & SECURITY TOOLS            |                               |
|    - Power BI Premium Capacity (P1 6-Mo Allocation)| R   180,000                   |
|    - Third-Party Automated Testing Software       | R    50,000                   |
|    - Azure Sentinel / Defender for Cloud Ingestion| R    50,000                   |
|    SUBTOTAL LICENSING                             | R   280,000                   |
+---------------------------------------------------+-------------------------------+
| 4. THIRD-PARTY SPECIALIST CONSULTING & AUDIT      |                               |
|    - External CREST-Accredited VAPT Audit         | R   180,000                   |
|    - POPIA External Legal Compliance Verification  | R   120,000                   |
|    SUBTOTAL CONSULTING                            | R   300,000                   |
+---------------------------------------------------+-------------------------------+
| 5. TRAINING, CERTIFICATION & CHANGE MANAGEMENT    |                               |
|    - Azure Operational Training for Apex IT Staff  | R    60,000                   |
|    - User Change Management Workshops & Materials | R    40,000                   |
|    SUBTOTAL TRAINING                              | R   100,000                   |
+---------------------------------------------------+-------------------------------+
| TOTAL COST BASELINE (BAC):                        | **R 4,250,000**               |
| Management Reserve (10% Unforeseen Contingency):  | **R   425,000**               |
| TOTAL APPROVED PROJECT BUDGET:                    | **R 4,675,000**               |
+---------------------------------------------------+-------------------------------+
```

### 6.2 Monthly Expenditure Forecast and Cash Flow Baseline
Expenditure is aligned with project phase execution:
* **Month 1:** R 550,000 (Initiation, Landing Zone, Initial Licensing)
* **Month 2:** R 750,000 (DB Migration Sprints, Pipeline Setup)
* **Month 3:** R 800,000 (App Refactoring, Azure SQL MI Scaling)
* **Month 4:** R 850,000 (Power BI Build, Security Sentinel Deployment)
* **Month 5:** R 800,000 (Testing, External VAPT Audit, UAT Sprints)
* **Month 6:** R 500,000 (Cutover, Hypercare, Final Handover)
* **Cumulative Total:** **R 4,250,000**

### 6.3 Cost Control and Earned Value Baseline
Financial expenditure is tracked bi-weekly using Earned Value Management (EVM). Any Cost Variance ($CV = EV - AC$) or Schedule Variance ($SV = EV - PV$) deviating by more than **$\pm 5\%$** triggers a mandatory financial audit and corrective action plan.

---

## 7. STRATEGIC AND TACTICAL MANAGEMENT

### 7.1 Project Governance Framework
Project governance establishes clear oversight, authority boundaries, and stakeholder accountability through a three-tiered governance structure:

```
+-----------------------------------------------------------------------------------+
|                           PROJECT GOVERNANCE STRUCTURE                            |
+-----------------------------------------------------------------------------------+
| STEERING COMMITTEE (Executive Oversight)                                          |
| Chair: Chief Information Officer (CIO)                                            |
| Members: Chief Financial Officer (CFO), Retail Operations Director, PM             |
+-----------------------------------------------------------------------------------+
                                         |
                                         v
+-----------------------------------------------------------------------------------+
| PROJECT MANAGEMENT OFFICE / PM (Tactical Management & Delivery)                   |
| Lead: Senior Project Manager                                                      |
| Core Responsibility: IEEE SPMP Execution, EVM, Schedule, Risk, Quality            |
+-----------------------------------------------------------------------------------+
                                         |
                                         v
+-----------------------------------------------------------------------------------+
| TECHNICAL EXECUTION TEAM (Operational Delivery)                                   |
| Cloud Lead, Lead ERP Eng, Senior DBA, Power BI Specialist, Cyber Lead,            |
| DevOps Eng, QA Lead, Change Management Lead                                       |
+-----------------------------------------------------------------------------------+
```

### 7.2 Organizational Structure and Reporting Lines
* The **Senior Project Manager** reports directly to the **Steering Committee** bi-weekly.
* All eight technical leads maintain a direct functional reporting line to the Project Manager for project-related deliverables, while retaining administrative alignment to their respective functional line managers.

### 7.3 Decision-Making and Escalation Procedures
To prevent operational bottlenecks, decision authority is categorized into three escalation thresholds:
1. **Level 1 (Operational - Lead Level):** Technical implementation choices within standard architecture baselines. Time/cost impact: $0$.
2. **Level 2 (Tactical - Project Manager Level):** Schedule variances $< 3$ working days, budget reallocations $< 	ext{ZAR } 50,000$ within baseline, minor risk response strategy execution.
3. **Level 3 (Strategic - Steering Committee Level):** Any impact to scope baseline, schedule variance $> 5$ working days, expenditure exceeding ZAR 50,000, or activation of Management Reserve. Escalation resolution SLA is 48 hours.

---

## 8. HUMAN RESOURCE MANAGEMENT

### 8.1 Team Structure and Roster (9-Person Core Team)
The project team comprises nine highly specialized roles:
1. **Senior Project Manager (PM):** Overall project integration, scope, schedule, budget, risk, and stakeholder alignment.
2. **Cloud Solutions Architect / Lead:** Azure Landing Zone design, cloud governance, technical oversight.
3. **Lead ERP Systems Engineer:** ERP application code refactoring, interface re-routing, business logic validation.
4. **Senior Database Administrator (DBA):** Data cleansing, schema optimization, Azure SQL MI migration, data integrity validation.
5. **Power BI & Analytics Specialist:** Data Factory ETL development, Synapse data warehouse modeling, Power BI dashboard construction.
6. **Cybersecurity & POPIA Compliance Lead:** Azure Security Center, Sentinel SIEM, IAM Entra ID, POPIA compliance controls, VAPT coordination.
7. **DevOps & Infrastructure Engineer:** Infrastructure as Code (Terraform/Bicep), CI/CD pipelines, automated testing deployment.
8. **Senior Quality Assurance (QA) / Testing Lead:** Test plan creation, performance load testing execution, defect tracking, UAT coordination.
9. **Change Management & Training Lead:** User impact assessments, store manager training, stakeholder communications, hypercare support.

### 8.2 South African Industry Labor Rates and Staffing Budget

```
+-----------------------------------------------------------------------------------+
|                        SOUTH AFRICAN IT LABOR RATE & EFFORT SCHEDULE               |
+------------------------------+-------------------+-----------------+--------------+
| Team Role                    | Hourly Rate (ZAR) | Allocated Hours | Total Budget |
+------------------------------+-------------------+-----------------+--------------+
| Senior Project Manager       | R 850 / hr        | 960 hrs         | R 816,000    |
| Cloud Solutions Architect    | R 1,100 / hr      | 480 hrs         | R 528,000    |
| Lead ERP Systems Engineer    | R 900 / hr        | 800 hrs         | R 720,000    |
| Senior Database Administrator| R 950 / hr        | 720 hrs         | R 684,000    |
| Power BI Analytics Specialist| R 750 / hr        | 600 hrs         | R 450,000    |
| Cybersecurity & POPIA Lead   | R 950 / hr        | 480 hrs         | R 456,000    |
| DevOps Infrastructure Eng    | R 800 / hr        | 720 hrs         | R 576,000    |
| Senior QA / Testing Lead     | R 700 / hr        | 600 hrs         | R 420,000    |
| Change Management Lead       | R 650 / hr        | 400 hrs         | R 260,000    |
+------------------------------+-------------------+-----------------+--------------+
| TOTAL ALLOCATED LABOR:                           | 5,760 Hours     | R 4,910,000  |
| Adjusted Internal Blended Rate Allocation:       | (FTE Allocation)| **R 3,120,000**|
+-----------------------------------------------------------------------------------+
```

### 8.3 Staff Training and Skills Enablement Plan
To mitigate technical skills deficits, Month 1 incorporates targeted Microsoft Official Curriculum (MOC) training certifications funded under the project baseline:
* **DevOps & Cloud Architect:** *AZ-104 (Azure Administrator)* and *AZ-305 (Azure Solutions Architect)*.
* **Senior DBA:** *DP-300 (Administering Relational Databases on Microsoft Azure)*.
* **Cybersecurity Lead:** *SC-200 (Microsoft Security Operations Analyst)*.

### 8.4 Resource Loading, Motivation, and Work-Life Balance
To prevent team burnout, individual resource allocation is capped at **40 hours per week (100% capacity)**. Overtime during production cutover (Week 23) is offset with mandatory time-off in lieu. Team motivation is maintained through milestone completion bonuses and formal recognition during Steering Committee reviews.

---

## 9. CONFIGURATION AND CHANGE MANAGEMENT

### 9.1 Cloud Configuration Baselines and Infrastructure as Code (IaC)
All Azure cloud resources (VNets, Firewalls, App Services, SQL Instances) are declared, versioned, and deployed exclusively using **Terraform** and **Azure Bicep** Infrastructure as Code (IaC) templates. Manual console configuration ("ClickOps") is strictly prohibited in production to enforce baseline consistency and auditability.

### 9.2 Version Control and Branching Strategy
All application code, IaC templates, ETL pipelines, and documentation are maintained within a secure **Azure DevOps Git Repository** utilizing GitFlow branching:
* **`main` Branch:** Represents production-ready baselines. Direct commits are locked.
* **`staging` Branch:** Integration testing environment for UAT.
* **`feature/*` Branches:** Individual developer work branches merged exclusively via mandatory Pull Requests (PRs) requiring two peer approvals.

### 9.3 Integrated Change Control Workflow
Any change affecting project scope, schedule, cost baseline, or cloud configuration baselines must adhere to the formal 5-step Change Control Procedure:

```
+-----------------------------------------------------------------------------------+
|                        INTEGRATED CHANGE CONTROL WORKFLOW                         |
+-----------------------------------------------------------------------------------+
| [1. REQUEST] -> Submission of formal Change Request (CR) form with justification.  |
|                                         |                                         |
| [2. IMPACT ASSESSMENT] -> PM & Technical Leads evaluate Cost, Time, Risk & Scope. |
|                                         |                                         |
| [3. CCB REVIEW] -> Change Control Board (PM, CIO, Lead Architect) meets weekly.   |
|                                         |                                         |
| [4. DECISION] -> Approved, Rejected, or Deferred for further information.         |
|                                         |                                         |
| [5. IMPLEMENTATION & BASELINE UPDATE] -> Re-baseline SPMP, notify team & execute. |
+-----------------------------------------------------------------------------------+
```

---

## 10. DECISION (RATIONALE) MANAGEMENT

### 10.1 Decision Architecture and Documentation Framework
In accordance with modern software project management best practices, major architectural and management choices are documented using **Architectural Decision Records (ADRs)** and **Project Decision Records (PDRs)**. This provides auditable traceability for design choices and trade-offs.

### 10.2 Key Architectural Decision Records (ADRs)

#### ADR-001: Selection of Azure SQL Managed Instance vs. IaaS SQL Server on VMs
* **Context:** The legacy ERP relies heavily on SQL Server Agent jobs, cross-database queries, and CLR modules.
* **Decision:** Provision **Azure SQL Managed Instance (Business Critical Tier)** instead of hosting SQL Server on Azure Infrastructure as a Service (IaaS) Virtual Machines.
* **Rationale:** Azure SQL MI provides near-100% compatibility with legacy SQL Server while eliminating OS patching, delivering automated backups, and guaranteeing an SLA of 99.99%. IaaS would have retained significant operational management overhead.

#### ADR-002: Adoption of Hybrid (Waterfall + Agile) Delivery Lifecycle
* **Context:** Strict governance and cutover windows must co-exist with rapid, iterative development of ETL pipelines and reports.
* **Decision:** Utilize Waterfall stage-gates for project governance and cutover while running 2-week Agile Sprints for technical execution.
* **Rationale:** Pure Agile introduced cutover risk, whereas pure Waterfall restricted rapid user feedback during Power BI report development.

### 10.3 Trade-Off Analysis Matrix

```
+-----------------------------------------------------------------------------------+
|                            ARCHITECTURAL TRADE-OFF MATRIX                         |
+-----------------------+-----------------------+-------------------+---------------+
| Decision Option       | Architectural Pros    | Technical Cons    | PM Rationale  |
+-----------------------+-----------------------+-------------------+---------------+
| Azure SQL Managed     | Near 100% SQL compat, | Higher monthly    | Selected:     |
| Instance (PaaS)       | automated patching,   | cloud runtime     | Minimizes risk|
|                       | 99.99% SLA uptime     | cost vs basic IaaS| & DB refactor |
+-----------------------+-----------------------+-------------------+---------------+
| SQL Server on Azure   | Lower immediate cloud | High administrative| Rejected:    |
| Virtual Machines(IaaS)| hosting license fee   | overhead; OS patch| Retains on-prem|
|                       |                       | burden remains    | maintenance   |
+-----------------------+-----------------------+-------------------+---------------+
```

---

## 11. RISK MANAGEMENT

### 11.1 Risk Governance and Methodology
Risk management follows the **ISO 31000 Risk Management Standard**. Risks are evaluated based on Probability ($P \in [1..5]$) and Impact ($I \in [1..5]$) to derive a Risk Score ($R = P 	imes I \in [1..25]$).

### 11.2 Qualitative Risk Assessment Matrix

```
+-----------------------------------------------------------------------------------+
|                             QUALITATIVE RISK MATRIX (P x I)                       |
+-------------------+---------------+---------------+---------------+---------------+
| PROBABILITY       | Impact: Low(2)| Impact: Med(3)| Impact: High(4)| Impact: Crit(5)|
+-------------------+---------------+---------------+---------------+---------------+
| Almost Certain (5)| Medium (10)   | High (15)     | Extreme (20)  | Extreme (25)  |
| Likely (4)        | Low (8)       | Medium (12)   | High (16)     | Extreme (20)  |
| Moderate (3)      | Low (6)       | Medium (9)    | High (12)     | High (16)     |
| Unlikely (2)      | Low (4)       | Low (6)       | Medium (8)    | Medium (10)   |
+-------------------+---------------+---------------+---------------+---------------+
```

### 11.3 Cloud-Specific and Local Risk Mitigation Strategies
Detailed mitigation strategies for top project risks (including load-shedding, POPIA non-compliance, cost overruns, and cutover downtime) are maintained within the active Risk Register (**Appendix C**).

---

## 12. QUALITY MANAGEMENT

### 12.1 Quality Planning and ISO 9001 Alignment
Quality management is framed around **ISO 9001:2015 Quality Management Principles**:
1. **Customer Focus:** Ensuring system performance meets retail store operations requirements.
2. **Process Approach:** Defining strict, repeatable automated workflows for testing and deployment.
3. **Continuous Improvement:** Integrating retrospective feedback after each 2-week Sprint.

### 12.2 Capability Maturity Model Integration (CMMI) KPAs
The project embeds Key Process Areas (KPAs) corresponding to **CMMI Level 3 (Defined)**:
* **Requirements Management:** Traceability matrix linking business requirements to automated test cases.
* **Software Quality Assurance (SQA):** Independent peer reviews and compliance audits.
* **Verification and Validation:** Automated unit testing, integration testing, and formal UAT.

### 12.3 Quality Assurance (QA) and Review Mechanisms
* **Peer Reviews:** Mandatory peer review for all IaC Bicep templates and SQL ETL scripts prior to pull request merging.
* **Stage-Gate Quality Audits:** SQA lead verifies deliverable completeness against acceptance criteria at each Stage-Gate.

### 12.4 Quality Control (QC) Metrics and Acceptance Standards

```
+-----------------------------------------------------------------------------------+
|                        QUALITY CONTROL METRIC THRESHOLDS                          |
+-----------------------+-----------------------------+-----------------------------+
| Quality Metric        | Measurement Method          | Target Acceptance Threshold |
+-----------------------+-----------------------------+-----------------------------+
| Defect Density        | Defects per KLOC / Module   | < 0.5 Critical Defects/KLOC |
| Mean Time To Fail(MTTF| Continuous Load Stress Test | > 720 Hours Continuous      |
| Database Data Integrity| SHA-256 Checksum Validation | 100% Match (Zero Variance)  |
| Transaction Latency   | APM Query Performance Monitor| < 1.2 Seconds per Lookup   |
| System Availability   | Azure Monitor SLA Auditing  | >= 99.9% Uptime SLA         |
| Test Case Coverage    | Automated Azure Pipeline    | >= 85% Code Coverage        |
+-----------------------+-----------------------------+-----------------------------+
```

---

## 13. PROCUREMENT MANAGEMENT

### 13.1 Cloud Infrastructure and Licensing Procurement
Azure cloud infrastructure services and Power BI Premium capacity are procured via Apex Retail’s existing **Microsoft Enterprise Agreement (EA)**, leveraging pre-negotiated corporate monetary commitments to secure a 15% discount on Azure consumption rates.

### 13.2 Vendor Selection and Managed Service Partner (MSP) Engagement
To support specialized activities, two third-party vendors are engaged under formal Statement of Work (SOW) contracts:
1. **CREST-Accredited Security Vendor:** Engaged to perform the external Vulnerability Assessment and Penetration Testing (VAPT) during Month 5.
2. **Microsoft Gold Partner MSP:** Engaged for specialized 24/7 cutover escalation support during Week 23.

### 13.3 Service Level Agreements (SLAs) and Vendor Oversight
All external vendors are bound by contractual SLAs enforcing a 1-hour response time for Critical (Severity 1) issues, with financial penalty deductions applied to final contract disbursements for non-performance.

---

## 14. PROJECT MONITORING AND REPORTING

### 14.1 Earned Value Management (EVM) Baseline
Project performance is measured bi-weekly using standard EVM calculations:
* **Planned Value (PV):** Approved budget assigned to scheduled work.
* **Earned Value (EV):** Value of work actually completed.
* **Actual Cost (AC):** Actual cost incurred for completed work.
* **Schedule Performance Index ($SPI = rac{EV}{PV}$):** Target $SPI \ge 1.0$.
* **Cost Performance Index ($CPI = rac{EV}{AC}$):** Target $CPI \ge 1.0$.

### 14.2 Progress Measurement and Status Reporting Cadence
* **Daily Standup (15 Mins):** Core team operational alignment and impediment removal.
* **Weekly Project Status Report:** Distributed every Friday by the PM, summarizing EVM metrics, completed deliverables, and upcoming tasks.
* **Bi-Weekly Steering Committee Pack:** Formal presentation of project health, financial burn rate, risk status, and stage-gate progress.

### 14.3 Key Performance Indicators (KPIs)
* **Schedule Variance (SV):** Target $\pm 3$ days.
* **Cost Variance (CV):** Target $\pm 2\%$ of monthly baseline.
* **Open Unresolved Critical Defects:** Target $= 0$ at end of Sprint cycles.

---

## 15. APPENDICES

---

### APPENDIX A: High-Level Master Gantt Chart (6-Month Schedule)

```
+-----------------------------------------------------------------------------------+
| MASTER PROJECT GANTT CHART (WEEKS 1 TO 24)                                        |
+------------------------------------+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
| WBS Task Name                      |M1|M2|M3|M4|M5|M6|M7|M8|M9|10|11|12|13|14|15|
+------------------------------------+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
| 1.0 Project Management & Governance|X |X |X |X |X |X |X |X |X |X |X |X |X |X |X |
| 1.1 Charter & Baseline Approval    |XX|  |  |  |  |  |  |  |  |  |  |  |  |  |  |
| 2.0 Azure Cloud Architecture Setup |  |XX|XX|XX|  |  |  |  |  |  |  |  |  |  |  |
| 2.1 Landing Zone & Governance      |  |XX|  |  |  |  |  |  |  |  |  |  |  |  |  |
| 2.2 Network Topology & ExpressRoute|  |  |XX|XX|  |  |  |  |  |  |  |  |  |  |  |
| 2.3 Identity (Entra ID) & Security |  |  |  |XX|  |  |  |  |  |  |  |  |  |  |  |
| 3.0 Database & App Migration       |  |  |  |XX|XX|XX|XX|XX|XX|  |  |  |  |  |  |
| 3.1 DB Audit, Schema & SQL MI Prov |  |  |  |XX|XX|XX|  |  |  |  |  |  |  |  |  |
| 3.2 Data Factory Pipelines & DMS   |  |  |  |  |  |XX|XX|XX|  |  |  |  |  |  |  |
| 3.3 App Modernization & Refactoring|  |  |  |  |  |  |XX|XX|XX|  |  |  |  |  |  |
| 4.0 Power BI Analytics Layer       |  |  |  |  |  |  |  |XX|XX|XX|XX|  |  |  |  |
| 5.0 Security Hardening & POPIA     |  |  |  |  |  |  |  |  |XX|XX|XX|XX|  |  |  |
| 6.0 Testing, Cutover & Hypercare   |  |  |  |  |  |  |  |  |  |  |  |XX|XX|XX|XX|
| 6.1 Performance & UAT Testing      |  |  |  |  |  |  |  |  |  |  |  |XX|XX|  |  |
| 6.2 External VAPT Security Audit   |  |  |  |  |  |  |  |  |  |  |  |  |XX|  |  |
| 6.3 Production Cutover Execution   |  |  |  |  |  |  |  |  |  |  |  |  |  |XX|  |
| 6.4 14-Day Hypercare & Project Close|  |  |  |  |  |  |  |  |  |  |  |  |  |  |XX|
+------------------------------------+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
(Continued Weeks 16 to 24: Testing [16-20], VAPT [21], Cutover [23], Closure [24])
```

---

### APPENDIX B: Monthly Cash Flow Projection (ZAR)

```
+-----------------------------------------------------------------------------------+
|                        MONTHLY CASH FLOW PROJECTION BASELINE (ZAR)                 |
+-----------------------+-----------+-----------+-----------+-----------+-----------+
| Expense Category      | Month 1   | Month 2   | Month 3   | Month 4   | Month 5   |
+-----------------------+-----------+-----------+-----------+-----------+-----------+
| Personnel Labor       | R 450,000 | R 520,000 | R 550,000 | R 560,000 | R 540,000 |
| Azure Cloud Runtime   | R  30,000 | R  60,000 | R  80,000 | R 100,000 | R 110,000 |
| Software Licensing    | R  70,000 | R  40,000 | R  40,000 | R  50,000 | R  40,000 |
| External VAPT & Audit | R       0 | R       0 | R  30,000 | R  40,000 | R 110,000 |
| Training & Ops Change | R  20,000 | R  20,000 | R  20,000 | R  20,000 | R  20,000 |
+-----------------------+-----------+-----------+-----------+-----------+-----------+
| MONTHLY TOTAL         | R 570,000 | R 640,000 | R 720,000 | R 770,000 | R 820,000 |
| CUMULATIVE EXPENDITURE| R 570,000 |R1,210,000 |R1,930,000 |R2,700,000 |R3,520,000 |
+-----------------------------------------------------------------------------------+
(Month 6 Final Disbursement: R 730,000 -> Bringing Cumulative Total to R 4,250,000)
```

---

### APPENDIX C: Comprehensive Project Risk Register (16 Cloud & Local Risks)

```
+-----------------------------------------------------------------------------------------------------------------------------------+
|                                                 COMPREHENSIVE PROJECT RISK REGISTER                                               |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| ID | Risk Description                 | P | I | Score| Strategy         | Response Plan / Mitigation            | Owner           |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R01| Excessive DB Cutover Downtime    | 3 | 5 | 15  | Mitigate          | Run parallel live DMS sync; test cutover| Senior DBA      |
|    | exceeding allowable 4-hr window  |   |   |     |                   | rehearsal during Month 5 dry-run.     |                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R02| Municipal Load-Shedding/Power Grid| 4 | 4 | 16  | Mitigate          | Cloud execution eliminates local host;| Senior DevOps   |
|    | outage disrupting staging servers|   |   |     |                   | deployment to Azure SA North region.  |                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R03| Data Loss or Corruption during   | 2 | 5 | 10  | Avoid             | Automated SHA-256 checksum audits on  | Senior DBA      |
|    | database ETL migration           |   |   |     |                   | all migrated tables before cutover.   |                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R04| POPIA Compliance Non-Compliance  | 2 | 5 | 10  | Mitigate          | Enable TDE encryption at-rest, TLS 1.3| Cyber Lead      |
|    | & Unencrypted Data Exposure      |   |   |     |                   | in-transit, and conduct VAPT audit.   |                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R05| Uncontrolled Azure Cloud Runtime | 3 | 4 | 12  | Mitigate          | Enforce Azure Cost Budgets & automated| Cloud Architect |
|    | Expenditure (Cost Overruns)      |   |   |     |                   | resource shutdown in non-prod.        |                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R06| Key Personnel Resignation or     | 3 | 3 |  9  | Mitigate          | Mandatory peer pairing and complete   | Project Manager |
|    | Critical Illness during execution|   |   |     |                   | documentation in DevOps wiki.         |                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R07| Resistance to Change from Retail | 3 | 3 |  9  | Mitigate          | Conduct early change management       | Change Lead     |
|    | Store & Operations Managers      |   |   |     |                   | workshops & hands-on Power BI training|                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R08| Third-Party Vendor SLA Failure   | 2 | 4 |  8  | Transfer          | Include strict contractual penalties  | Project Manager |
|    | during VAPT or MSP Cutover Support|  |   |     |                   | and requiring backup vendor agreements.|                |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R09| Legacy ERP Custom Code           | 3 | 4 | 12  | Mitigate          | Perform early Month 2 code audit and  | Lead ERP Eng    |
|    | Incompatibility with Azure MI    |   |   |     |                   | refactor database stored procedures.  |                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R10| WAN Fiber Latency / Degradation  | 3 | 3 |  9  | Mitigate          | Provision ExpressRoute circuit with   | Cloud Architect |
|    | between Cape Town & Joburg Hubs  |   |   |     |                   | redundant IPSec VPN backup link.      |                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R11| Power BI ETL Refresh Pipeline    | 2 | 3 |  6  | Mitigate          | Optimize SQL indexing and utilize     | Power BI Lead   |
|    | Latency Exceeding 15-Min Threshold|  |   |     |                   | Incremental Data Refresh feature.     |                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R12| Ransomware / Cyber Security      | 2 | 5 | 10  | Avoid             | Deploy Azure Sentinel SIEM, Defender  | Cyber Lead      |
|    | Threat during Migration Phase    |   |   |     |                   | for Cloud, and MFA on all accounts.   |                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R13| Scope Creep from Retail          | 4 | 3 | 12  | Mitigate          | Enforce strict Change Control Board   | Project Manager |
|    | Stakeholder Feature Requests     |   |   |     |                   | (CCB) review for all new requests.    |                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R14| Inadequate Disaster Recovery (DR)| 2 | 4 |  8  | Mitigate          | Provision GRS storage and conduct     | Senior DevOps   |
|    | Failover Validation              |   |   |     |                   | simulated DR failover drill in M5.    |                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R15| Identity Sync Failures during    | 2 | 3 |  6  | Mitigate          | Pre-stage Entra ID Connect and test   | Cyber Lead      |
|    | Entra ID Single Sign-On (SSO)    |   |   |     |                   | federated login during Sprint 4.      |                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
| R16| User Acceptance Testing (UAT)    | 3 | 3 |  9  | Mitigate          | Schedule dedicated SME time blocks    | Senior QA Lead  |
|    | Bottlenecks due to SME Unavailability| |   |     |                   | agreed upon with Department Heads.    |                 |
+----+----------------------------------+---+---+-----+-------------------+---------------------------------------+-----------------+
```

---

### APPENDIX D: Responsibility Assignment Matrix (RACI)

```
+--------------------------------------------------------------------------------------------------------------------+
|                                    RESPONSIBILITY ASSIGNMENT MATRIX (RACI)                                         |
+--------------------------------------+----+----+----+----+----+----+----+----+----+
| Deliverable / WBS Activity           | PM | CA | EE | DB | PB | SE | DO | QA | CM |
+--------------------------------------+----+----+----+----+----+----+----+----+----+
| 1.1 Project Charter & IEEE SPMP Baseline| A  | C  | C  | C  | C  | C  | C  | C  | C  |
| 2.1 Azure Landing Zone & Governance  | I  | A/R| C  | C  | I  | C  | R  | I  | I  |
| 2.2 Network & ExpressRoute Setup     | I  | A  | I  | I  | I  | C  | R  | C  | I  |
| 2.3 Entra ID IAM & RBAC Security     | I  | C  | I  | I  | I  | A/R| C  | C  | I  |
| 3.1 SQL Database Audit & Cleansing   | I  | C  | C  | A/R| I  | I  | C  | C  | I  |
| 3.2 Azure SQL MI Provisioning & Sync | I  | C  | I  | A/R| I  | C  | R  | C  | I  |
| 3.3 ERP Application Refactoring      | I  | C  | A/R| C  | I  | I  | C  | C  | I  |
| 4.1 Power BI Data Factory ETL Build  | I  | C  | C  | C  | A/R| I  | C  | C  | I  |
| 4.2 Executive & Operations Dashboards| I  | I  | C  | I  | A/R| I  | I  | C  | C  |
| 5.1 Azure Sentinel SIEM Deployment   | I  | C  | I  | I  | I  | A/R| C  | I  | I  |
| 5.2 External VAPT Security Audit     | A  | C  | I  | I  | I  | R  | I  | C  | I  |
| 6.1 Performance & Stress Testing     | I  | C  | C  | C  | I  | I  | C  | A/R| I  |
| 6.2 User Acceptance Testing (UAT)    | A  | I  | C  | I  | C  | I  | I  | R  | C  |
| 6.3 Production Cutover Execution     | A  | R  | R  | R  | R  | R  | R  | R  | C  |
| 6.4 User Training & Hypercare        | A  | I  | C  | I  | C  | I  | I  | C  | R  |
+--------------------------------------+----+----+----+----+----+----+----+----+----+
Legend:
PM = Senior Project Manager | CA = Cloud Architect | EE = Lead ERP Engineer | DB = Senior DBA
PB = Power BI Specialist | SE = Cybersecurity Lead | DO = DevOps Engineer | QA = QA Lead
CM = Change Management Lead
R = Responsible (Does the work) | A = Accountable (Final approval) | C = Consulted | I = Informed
```

---

### APPENDIX E: Resource Effort Summary and Effort Distribution

```
+-----------------------------------------------------------------------------------+
|                        RESOURCE EFFORT SUMMARY BY PHASE (IN PERSON-HOURS)          |
+------------------------------+-------+-------+-------+-------+-------+------------+
| Role                         | M1    | M2    | M3    | M4    | M5    | Total Hrs  |
+------------------------------+-------+-------+-------+-------+-------+------------+
| Senior Project Manager       | 180 h | 160 h | 160 h | 160 h | 140 h | 960 Hours  |
| Cloud Solutions Architect    | 120 h | 140 h | 100 h |  80 h |  40 h | 480 Hours  |
| Lead ERP Systems Engineer    |  60 h | 180 h | 220 h | 200 h | 140 h | 800 Hours  |
| Senior Database Administrator|  80 h | 200 h | 200 h | 140 h | 100 h | 720 Hours  |
| Power BI Analytics Specialist|  20 h |  80 h | 180 h | 200 h | 120 h | 600 Hours  |
| Cybersecurity & POPIA Lead   |  80 h | 100 h | 100 h | 120 h |  80 h | 480 Hours  |
| DevOps Infrastructure Eng    |  80 h | 180 h | 180 h | 160 h | 120 h | 720 Hours  |
| Senior QA / Testing Lead     |  20 h |  60 h | 140 h | 200 h | 180 h | 600 Hours  |
| Change Management Lead       |  20 h |  40 h |  80 h | 120 h | 140 h | 400 Hours  |
+------------------------------+-------+-------+-------+-------+-------+------------+
| MONTHLY CUMULATIVE HOURS     | 660 h |1,140 h|1,360 h|1,380 h|1,060 h| 5,760 Hours|
+-----------------------------------------------------------------------------------+
```
