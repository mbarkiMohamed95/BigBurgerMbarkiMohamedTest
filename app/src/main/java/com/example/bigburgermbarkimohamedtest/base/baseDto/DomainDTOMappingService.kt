package com.example.bigburgermbarkimohamedtest.base.baseDto


interface DomainDTOMappingService<Domain,DTO> {

    fun mapDomainToDTO(domain : Domain) : DTO

     fun mapDomainToDTO(domainlist : List<Domain>) : List<DTO> = domainlist.map { domain->
        mapDomainToDTO(domain)
    }
}