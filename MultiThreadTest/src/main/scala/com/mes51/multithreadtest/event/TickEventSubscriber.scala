package com.mes51.multithreadtest.event

import com.mes51.multithreadtest.processor.HeavyTaskProcessor
import net.minecraft.init.Blocks
import net.minecraft.util.math.BlockPos
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent

object TickEventSubscriber {
  var airCount = 0

  @SubscribeEvent
  def onTickEvent(e: TickEvent.WorldTickEvent): Unit = {
    if (!HeavyTaskProcessor.isProcessing) {
      System.out.println(s"air count: ${airCount}")
      HeavyTaskProcessor.post(() => {
        System.out.println("process start")
        // heavy process
        val c = 0.to(100).flatMap(x => {
          0.to(255).flatMap(y => {
            0.to(100).map(z => {
              e.world.getBlockState(new BlockPos(x, y, z)).getBlock == Blocks.AIR
            })
          })
        })
        airCount = c.count(identity)
      })
    } else {
      System.out.println("air counting...")
    }
  }
}
