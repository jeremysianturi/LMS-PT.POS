package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.dropdown.CompanyEnitity
import com.pos.lms.core.data.source.remote.response.dropdown.CompanyResponse
import com.pos.lms.core.domain.model.Company

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperCompany {

    fun mapResponsesToEntities(input: List<CompanyResponse>): List<CompanyEnitity> {
        val list = ArrayList<CompanyEnitity>()
        input.map {
            val entity = CompanyEnitity(
                endDate = it.endDate,
                country = it.country,
                objectIdentifier = it.objectIdentifier,
                companyId = it.companyId,
                city = it.city,
                changeDate = it.changeDate,
                beginDate = it.beginDate,
                businessCode = it.businessCode,
                province = it.province,
                phone = it.phone,
                street = it.street,
                companyName = it.companyName,
                changeUser = it.changeUser,
                postalCode = it.postalCode
            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<CompanyEnitity>): List<Company> =
        input.map {
            Company(
                endDate = it.endDate,
                country = it.country,
                objectIdentifier = it.objectIdentifier,
                companyId = it.companyId,
                city = it.city,
                changeDate = it.changeDate,
                beginDate = it.beginDate,
                businessCode = it.businessCode,
                province = it.province,
                phone = it.phone,
                street = it.street,
                companyName = it.companyName,
                changeUser = it.changeUser,
                postalCode = it.postalCode
            )
        }

}