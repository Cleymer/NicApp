package com.cjzt.nicapp.room

import com.cjzt.nicapp.model.Place
import com.cjzt.nicapp.retrofit.PlaceNetworkEntity
import com.cjzt.nicapp.utils.EntityMapper
import javax.inject.Inject


class CacheMapper
@Inject
constructor():
    EntityMapper<PlaceCacheEntity, Place>{

        override fun mapFromEntity(entity: PlaceCacheEntity): Place {
            return Place(
                id = entity.id,
                name = entity.name,
                description = entity.description,
                image = entity.image
            )
        }

        override fun mapToEntity(domainModel: Place): PlaceCacheEntity {
            return PlaceCacheEntity(
                id = domainModel.id,
                name = domainModel.name,
                description = domainModel.description,
                image = domainModel.image
            )
        }

        fun mapFromEntityList(entities: List<PlaceCacheEntity>): List<Place>{
            return entities.map { mapFromEntity(it) }
        }
    }