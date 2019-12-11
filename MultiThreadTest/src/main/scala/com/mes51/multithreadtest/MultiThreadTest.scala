package com.mes51.multithreadtest

import com.mes51.multithreadtest.event.TickEventSubscriber
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.{EventBusSubscriber, EventHandler}
import net.minecraftforge.fml.common.event.FMLInitializationEvent

object MultiThreadTestProps {
  final val MOD_ID = "multithreadtest"
  final val NAME = "MultiThreadTest"
  final val VERSION = "1.0.0"
  final val MINECRAFT_VERSION = "[1.12]"
}

@Mod(
  name = MultiThreadTestProps.NAME,
  modid = MultiThreadTestProps.MOD_ID,
  version = MultiThreadTestProps.VERSION,
  acceptedMinecraftVersions = MultiThreadTestProps.MINECRAFT_VERSION,
  modLanguage = "scala"
)
@EventBusSubscriber
object MultiThreadTest {
  @EventHandler
  def init(e: FMLInitializationEvent): Unit = {
    MinecraftForge.EVENT_BUS.register(TickEventSubscriber)
  }
}