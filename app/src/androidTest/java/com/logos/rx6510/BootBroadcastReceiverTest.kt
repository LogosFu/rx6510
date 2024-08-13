package com.logos.rx6510

import android.content.Context
import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.argThat
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

@RunWith(AndroidJUnit4::class)
class BootBroadcastReceiverTest {

    @Test
    fun onReceive_bootCompleted_shouldStartMainActivity() {

        // 1. 创建 Mock 对象
        val context = Mockito.mock(Context::class.java)
        val intent = Intent(Intent.ACTION_BOOT_COMPLETED)
        // 3. 创建 BootBroadcastReceiver 实例
        val receiver = BootBroadcastReceiver()

        // 4. 调用 onReceive 方法
        receiver.onReceive(context, intent)

        // 5. 验证 startActivity 方法的调用
        val expectedIntent = Intent(context, MainActivity::class.java)
        expectedIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        verify(context).startActivity(argThat {
            it.component?.className == MainActivity::class.java.name &&
                    (it.flags and Intent.FLAG_ACTIVITY_NEW_TASK) == Intent.FLAG_ACTIVITY_NEW_TASK
        })
    }
}