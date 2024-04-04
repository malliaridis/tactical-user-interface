package com.chipmunksmedia.helldivers.remote.model

data class Stratagem(
    val id: String,
    val dialCode: Array<Direction>,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Stratagem

        if (id != other.id) return false
        if (!dialCode.contentEquals(other.dialCode)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + dialCode.contentHashCode()
        return result
    }
}
