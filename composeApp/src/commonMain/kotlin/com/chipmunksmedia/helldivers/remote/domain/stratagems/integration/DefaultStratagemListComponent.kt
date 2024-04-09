package com.chipmunksmedia.helldivers.remote.domain.stratagems.integration

import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponentContext
import com.chipmunksmedia.helldivers.remote.domain.stratagems.StratagemListComponent
import com.chipmunksmedia.helldivers.remote.domain.stratagems.StratagemListComponent.Model
import com.chipmunksmedia.helldivers.remote.model.Direction.Down
import com.chipmunksmedia.helldivers.remote.model.Direction.Left
import com.chipmunksmedia.helldivers.remote.model.Direction.Right
import com.chipmunksmedia.helldivers.remote.model.Direction.Up
import com.chipmunksmedia.helldivers.remote.model.Stratagem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DefaultStratagemListComponent(
    componentContext: AppComponentContext,
) : StratagemListComponent, AppComponentContext by componentContext {

    // TODO Replace mutable state flow with store state
    override val models: StateFlow<Model> = MutableStateFlow(
        Model(stratagems = getStratagems())
    )

    override fun onReloadStratagems() {
        TODO("Not yet implemented")
    }
}

private fun getStratagems() = listOf(
    Stratagem(
        id = "st_reinforce",
        dialCode = arrayOf(Up, Down, Right, Left, Up),
        availabilityCount = 10,
        state = Stratagem.State.Available,
    ),
    Stratagem(
        id = "st_resupply",
        dialCode = arrayOf(Down, Down, Up, Right),
        availabilityCount = 1,
        state = Stratagem.State.Available,
    ),
    Stratagem(
        id = "st_hellbomb",
        dialCode = arrayOf(Down, Up, Left, Down, Up, Right, Down, Up),
        availabilityCount = 1,
        state = Stratagem.State.Available,
    ),
)
