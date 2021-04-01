package com.cjzt.nicapp.retrofit

import javax.inject.Inject
import com.cjzt.nicapp.model.Place
import com.cjzt.nicapp.utils.EntityMapper

class NetworkMapper
@Inject
constructor() : EntityMapper<PlaceNetworkEntity, Place>{
    override fun mapFromEntity(entity: PlaceNetworkEntity): Place {
        return Place(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            image = entity.image
        )
    }

    override fun mapToEntity(domainModel: Place): PlaceNetworkEntity {
        return  PlaceNetworkEntity(
            id = domainModel.id,
            name = domainModel.name,
            description = domainModel.description,
            image = domainModel.image
        )
    }

    fun mapFromEntityList(entities: List<PlaceNetworkEntity>): List<Place>{
        return entities.map { mapFromEntity(it) }
    }
}