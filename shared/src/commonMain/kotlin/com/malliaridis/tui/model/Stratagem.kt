package com.malliaridis.tui.model

import kotlinx.datetime.Instant
import kotlin.time.Duration

/**
 * @property id Unique ID of this stratagem.
 * @property dialCode Dial code required for calling in this stratagem.
 * @property state Current availability state of this stratagem.
 * @property availabilityCount Amount of available units before depleted.
 */
data class Stratagem(
    val id: String,
    val dialCode: Array<Direction>,
    val state: State,
    val availabilityCount: Int,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Stratagem

        if (id != other.id) return false
        if (!dialCode.contentEquals(other.dialCode)) return false
        if (state != other.state) return false
        if (availabilityCount != other.availabilityCount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + dialCode.contentHashCode()
        result = 31 * result + state.hashCode()
        result = 31 * result + availabilityCount
        return result
    }

    sealed interface State {

        /**
         * The stratagem is available to the user.
         */
        data object Available : State

        /**
         * The stratagem is unavailable.
         */
        data object Unavailable : State

        /**
         * The stratagem is on cooldown.
         *
         * @property cooldownStartedAt Timestamp when the cooldown started.
         * @property cooldownDuration How long the cooldown lasts (in total).
         */
        data class OnCooldown(
            val cooldownStartedAt: Instant,
            val cooldownDuration: Duration,
        ) : State

        data class Incoming(
            val calledInAt: Instant,
            val callInTime: Duration,
        ) : State
    }
}
