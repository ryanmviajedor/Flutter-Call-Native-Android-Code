import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  var channel = const MethodChannel('flutter.native.helper');

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.indigo,
      body: Center(
        child: ElevatedButton(
          onPressed: showToast,
          child: const Text('MADA PAY'),
        ),
      ),
    );
  }

  Future showToast() async {
    await channel
        .invokeMethod("MADAPayment", {'message': "Confirm MADA Payment"});
  }
}
