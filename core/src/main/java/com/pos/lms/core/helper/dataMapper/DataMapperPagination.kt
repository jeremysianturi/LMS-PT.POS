package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.PaginationEntity
import com.pos.lms.core.data.source.remote.response.student.forum.PaginationResponse
import com.pos.lms.core.domain.model.Pagination

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperPagination {

    fun mapResponsetoEntities(input: PaginationResponse): PaginationEntity {
        return PaginationEntity(
            perPage = input.perPage,
            total = input.total,
            count = input.count,
            totalPages = input.totalPages,
            currentPage = input.currentPage,
        )

    }

    fun mapEntitiestoDomain(input: PaginationEntity) =
        Pagination(
            perPage = input.perPage,
            total = input.total,
            count = input.count,
            totalPages = input.totalPages,
            currentPage = input.currentPage,
        )
}