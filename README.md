# Kusto KQL Testing with Kotlin

As a developer, I'd like to be able to have a development loop that includes query validation using a known set of input data with my Query that I'm currently working on. This story focuses on "headless" approach that does not use a GUI based interface such as Kusto Explorer - which is Windows Only today or the ADX Browser Based interface. Ideally, this could also be run in a pipeline under an Agent in headless mode as well.

This should require a few environmental dependencies that are reasonable, although I'm aware that Kusto query must be tested against a Cloud Based Azure Data Explorer Cluster (ADX) cluster. In addition, the creation/destroy of an Azure Data Explorer cluster, even a Dev/Test scale size takes "minutes ~= 5 or more".


## Background Links and Information

### Approach
The Kusto / ADX support is somewhat split across two different SDKs for Java (and other languages). In addition, the Azure CLI Kusto extension as of January 2022 provides the basic Cluster, Principal, Database level management.

In ADX, Cluster are the true "hosts" while the Database is the container that is tightly coupled with Schema, Functions, and all scripts that can be defined for working with the data and utilized by applications like Kusto Query.

```
$ az kusto --help 
Group
    az kusto : Manage Kusto.
        This command group is experimental and under development. Reference and support levels:
        https://aka.ms/CLI_refstatus
Subgroups:
    attached-database-configuration : Manage attached database configuration with kusto.
    cluster                         : Manage cluster with kusto.
    cluster-principal-assignment    : Manage cluster principal assignment with kusto.
    data-connection                 : Manage data connection with kusto.
    database                        : Manage database with kusto.
    database-principal-assignment   : Manage database principal assignment with kusto.
    managed-private-endpoint        : Manage managed private endpoint with kusto.
    operation-result                : Manage operation result with kusto.
    private-endpoint-connection     : Manage private endpoint connection with kusto.
    private-link-resource           : Manage private link resource with kusto.
    script                          : Manage script with kusto.

$ az kusto script --help

Group
    az kusto script : Manage script with kusto.
        Command group 'kusto' is experimental and under development. Reference and support
        levels: https://aka.ms/CLI_refstatus
Commands:
    create : Creates a Kusto database script.
    delete : Deletes a Kusto principalAssignment.
    list   : Returns the list of database scripts for given database.
    show   : Gets a Kusto cluster database script.
    update : Updates a database script.
    wait   : Place the CLI in a waiting state until a condition of the kusto script is met.

```

#### Infrastructure Tests
These tests are to leverage the Azure Java SDK with the infrastructure focused areas such as cluster, database, perhaps scripts.
[Azure Java SDK - Kusto/ADX](https://github.com/Azure/azure-sdk-for-java/tree/main/sdk/kusto/azure-resourcemanager-kusto)

#### Logic and Schema Tests
Logic tests, data seeding, query requests, via the [Azure Kusto Java SDK](https://github.com/Azure/azure-kusto-java)


### DSL In Kotlin
May review or potentially provide a basic DSL for testing.

### Other Thoughts
The Kusto CLI tool provides some capabilities for running scripts, queries, etc. It cannot create clusters. [DOC](https://docs.microsoft.com/en-us/azure/data-explorer/kusto/tools/kusto-cli)

