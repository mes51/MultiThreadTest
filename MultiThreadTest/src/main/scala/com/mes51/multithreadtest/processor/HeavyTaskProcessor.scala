package com.mes51.multithreadtest.processor

object HeavyTaskProcessor {
  private var thread: Thread = _;

  def isProcessing: Boolean = {
    if (thread != null) {
      thread.isAlive
    } else {
      false
    }
  }

  def post(p: () => Unit): Unit = {
    thread = new Thread {
      override def run(): Unit = p()
    }
    thread.start()
  }
}
