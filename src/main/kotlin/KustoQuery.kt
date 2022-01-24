package me.reference.kotlintesting

import com.microsoft.azure.kusto.data.ClientImpl
import com.microsoft.azure.kusto.data.auth.ConnectionStringBuilder
import com.microsoft.azure.kusto.data.auth.ConnectionStringBuilder.createWithAadApplicationCredentials

class KustoQuery {
    fun getClient() {
        val csb = ConnectionStringBuilder.createWithAadApplicationCredentials(
            System.getProperty("clusterPath"),
            System.getProperty("appId"),
            System.getProperty("appKey"),
            System.getProperty("appTenant")
        )
        val client = ClientImpl(csb)
    }
}