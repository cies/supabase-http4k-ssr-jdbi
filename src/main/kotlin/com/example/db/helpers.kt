package com.example.db

import java.time.Instant
import java.time.OffsetDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object InstantToPgTimestamptzSerializer : KSerializer<Instant> {

  override val descriptor: SerialDescriptor =
    PrimitiveSerialDescriptor("import java.time.Instant", PrimitiveKind.STRING)

  override fun deserialize(decoder: Decoder): Instant =
    OffsetDateTime.parse(decoder.decodeString().replace(" ", "T")).toInstant()

  override fun serialize(encoder: Encoder, value: Instant) {
    encoder.encodeString(value.toString().replace(" ", "T"))
  }
}
