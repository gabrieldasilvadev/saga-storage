package br.com.sagastorage.inventoryservice.adapters.out.kafka.groups

enum class GroupId(private val groupName: String) {
    SALE("sale");

    fun getGroupName(): String {
        return groupName
    }
}