package com.harenko.currencies_test.data.deserializer

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.harenko.currencies_test.data.dto.CurrencyDto
import com.harenko.currencies_test.data.dto.GetCurrenciesResp
import java.lang.reflect.Type
import java.util.*

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

class CurrenciesRatesDeserializer : JsonDeserializer<GetCurrenciesResp.CurrenciesRatesDto> {

    override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
    ): GetCurrenciesResp.CurrenciesRatesDto {

        if (json == null) {
            return getEmptyDto()
        } else {
            return try {
                val jsonObject: JsonObject = json.asJsonObject

                GetCurrenciesResp.CurrenciesRatesDto(
                        rates = jsonObject.entrySet().map {
                            CurrencyDto(name = it.key, rateBasedOnEur = it.value.asDouble)
                        }
                )
            } catch (exception: Throwable) {
                getEmptyDto()
            }
        }
    }

    private fun getEmptyDto() = GetCurrenciesResp.CurrenciesRatesDto(rates = emptyList())
}