package com.example.football_api

import android.content.Context
import androidx.annotation.NonNull
import com.example.spors_api.Http.api

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/** FootballApiPlugin */
class FootballApiPlugin: FlutterPlugin, MethodCallHandler, ActivityAware {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity

  private lateinit var channel : MethodChannel
  private lateinit var context: Context
     private  var getlivematch : String = "getlivematch";
private  var getfixturematchbydate : String = "getfixturematchbydate";
private  var getallleague : String = "getallleague";
private  var getstatistics : String = "getstatistics";

private  var getstanding : String = "getstanding";
private  var getallteambyleagueid : String = "getallteambyleagueid";

private  var getteammatch : String = "getteammatch";
private  var getteaminfo : String = "getteaminfo";

private  var getteamstatiaties : String = "getteamstatiaties";


private  var getfixturedetails : String = "getfixturedetails";
private  var getheadtohead : String = "getheadtohead";

private  var getlineup : String = "getlineup";
private  var getfixturestatistic : String = "getfixturestatistic";

private  var getplayerstatistic : String = "getplayerstatistic";
private  var getfixtureevent : String = "getfixtureevent";

private  var getfixtureleaguedate : String = "getfixtureleaguedate";
private  var getteamplayerlist : String = "getteamplayerlist";
private  var getplayerlistseasonleagueteam : String = "getplayerlistseasonleagueteam";

private  var getplayertransfer : String = "getplayertransfer";
private  var getsingleplayerinfo : String = "getsingleplayerinfo";

private  var getplayersquard : String = "getplayersquard";

   

  

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "football_api")
    channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    CoroutineScope(Dispatchers.IO).launch {
      apihelp(call, result)
    }
  }


  fun apihelp(call: MethodCall, result: Result) {
    if (call.method == getlivematch) {
      CoroutineScope(Dispatchers.IO).async {
        var data = api(context).getlivematch()
        result.success("${data}")
      }

    } else if (call.method == getfixturematchbydate) {
      var date : String? = call.argument<String>("date")
      CoroutineScope(Dispatchers.IO).async {
        var data = api(context).getfixturematchbydate(date!!)
        result.success("${data}")
      }
    }else if (call.method == getallleague) {

      CoroutineScope(Dispatchers.IO).async {
        var data = api(context).getallleague()
        result.success("${data}")
      }
    }else if (call.method == getstatistics) {
      CoroutineScope(Dispatchers.IO).async {
        var date : Int? = call.argument<Int>("fixtureid")
        var data = api(context).getstatistics(date!!)
        result.success("${data}")
      }
    }else if (call.method == getstanding) {
      CoroutineScope(Dispatchers.IO).async {
        var league : Int? = call.argument<Int>("league")
        var season : Int? = call.argument<Int>("season")
        var data = api(context).getstanding(league!!, season!!)
        result.success("${data}")
      }
    }else if (call.method == getallteambyleagueid) {
       var league : Int? = call.argument<Int>("league")
        var season : Int? = call.argument<Int>("season")
      CoroutineScope(Dispatchers.IO).async {

        var data = api(context).getallteambyleagueid(league!!, season!!)
        result.success("${data}")
      }
    }else if (call.method == getteammatch) {
      var team : Int? = call.argument<Int>("team")
      var season : Int? = call.argument<Int>("season")
      CoroutineScope(Dispatchers.IO).async {
        var data = api(context).getteammatch(team!!, season!!)
        result.success("${data}")
      }
    }else if (call.method == getteaminfo) {
      CoroutineScope(Dispatchers.IO).async {
        var team : Int? = call.argument<Int>("team")
        var data = api(context).getteaminfo(team!!)
        result.success("${data}")
      }
    }else if (call.method == getteamstatiaties) {
      var league : Int? = call.argument<Int>("league")
      var team : Int? = call.argument<Int>("team")
      var season : Int? = call.argument<Int>("season")
      CoroutineScope(Dispatchers.IO).async {
        var data = api(context).getteamstatiaties(team!!, league!!, season!!)
        result.success("${data}")
      }
    }else if (call.method == getfixturedetails) {
      var fixtureid : Int? = call.argument<Int>("fixtureid")
      
      CoroutineScope(Dispatchers.IO).async {
        var data = api(context).getfixturedetails(fixtureid!!)
        result.success("${data}")
      }
    }else if (call.method == getheadtohead) {
      var h2h : String? = call.argument<String>("h2h")
      CoroutineScope(Dispatchers.IO).async {
        var data = api(context).getheadtohead(h2h!!)
        result.success("${data}")
      }
    }else if (call.method == getlineup) {
      var fixtureid : Int? = call.argument<Int>("fixtureid")
      CoroutineScope(Dispatchers.IO).async {
        var data = api(context).getlineup(fixtureid!!)
        result.success("${data}")
      }
    }else if (call.method == getfixturestatistic) {
      var fixtureid : Int? = call.argument<Int>("fixtureid")
      CoroutineScope(Dispatchers.IO).async {
        var data = api(context).getfixturestatistic(fixtureid!!)
        result.success("${data}")
      }
    }else if (call.method == getplayerstatistic) {
      var fixtureid : Int? = call.argument<Int>("fixtureid")
      CoroutineScope(Dispatchers.IO).async {

        var data = api(context).getplayerstatistic(fixtureid!!)
        result.success("${data}")
      }
    }else if (call.method == getfixtureevent) {
      var fixtureid : Int? = call.argument<Int>("fixtureid")
      CoroutineScope(Dispatchers.IO).async {

        var data = api(context).getfixtureevent(fixtureid!!)
        result.success("${data}")
      }
    }else if (call.method == getfixtureleaguedate) {
      var league : Int? = call.argument<Int>("league")
      var date : String? = call.argument<String>("date")
      var season : Int? = call.argument<Int>("season")

      CoroutineScope(Dispatchers.IO).async {
        var data = api(context).getfixtureleaguedate(date!!, league!!, season!!)
        result.success("${data}")
      }
    }else if (call.method == getteamplayerlist) {
      var team : Int? = call.argument<Int>("team")
      var season : Int? = call.argument<Int>("season")

      CoroutineScope(Dispatchers.IO).async {
        var data = api(context).getteamplayerlist(team!!, season!!)
        result.success("${data}")
      }
    }else if (call.method == getplayerlistseasonleagueteam) {
      var league : Int? = call.argument<Int>("league")
      var team : Int? = call.argument<Int>("team")
      var season : Int? = call.argument<Int>("season")
      CoroutineScope(Dispatchers.IO).async {

        var data = api(context).getplayerlistseasonleagueteam(team!!, season!!, league!!)
        result.success("${data}")
      }
    }else if (call.method == getplayertransfer) {
      var player : Int? = call.argument<Int>("player")
      var team : Int? = call.argument<Int>("team")
      CoroutineScope(Dispatchers.IO).async {

        var data = api(context).getplayertransfer(team!!, player!!)
        result.success("${data}")
      }
    }else if (call.method == getsingleplayerinfo) {
      var player : Int? = call.argument<Int>("player")
      var season : Int? = call.argument<Int>("season")
      CoroutineScope(Dispatchers.IO).async {

        var data = api(context).getsingleplayerinfo(season!!, player!!)
        result.success("${data}")
      }
    }else if (call.method == getplayersquard) {
      var player : Int? = call.argument<Int>("player")
      CoroutineScope(Dispatchers.IO).async {

        var data = api(context).getplayersquard(player!!)
        result.success("${data}")
      }
    }

    else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }

  override fun onAttachedToActivity(binding: ActivityPluginBinding) {
     context = binding.activity
  }

  override fun onDetachedFromActivityForConfigChanges() {
    TODO("Not yet implemented")
  }

  override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
    TODO("Not yet implemented")
  }

  override fun onDetachedFromActivity() {
    TODO("Not yet implemented")
  }
}