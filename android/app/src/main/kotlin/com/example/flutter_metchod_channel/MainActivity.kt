package com.example.flutter_metchod_channel

import android.widget.Toast
import android.content.*
import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val channelName = "flutter.native.helper";

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        var channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger,channelName);

        channel.setMethodCallHandler { call, result ->

            var args = call.arguments as Map<String, String>;
            var message = args["message"];

            if(call.method == "MADAPayment") {
                Toast.makeText(this, message,Toast.LENGTH_LONG).show();
            }
        }
    }
}
