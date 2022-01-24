pluginManagement {
    val kotlinJvmVersion: String by settings
    plugins {
        kotlin("jvm") version kotlinJvmVersion
    }
}

rootProject.name = "kusto-kotlin-unit-test"

