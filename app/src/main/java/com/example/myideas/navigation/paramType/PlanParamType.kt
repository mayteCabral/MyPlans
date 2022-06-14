package com.example.myideas.navigation.paramType

import android.os.Bundle
import androidx.compose.ui.tooling.preview.Device
import androidx.navigation.NavType
import com.example.myideas.model.Plan
import com.google.gson.Gson


class PlanParamType : NavType<Plan>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Plan? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Plan {
        return Gson().fromJson(value, Plan::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Plan) {
        bundle.putParcelable(key, value)
    }
}