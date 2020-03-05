/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * Generated with the TypeScript template
 * https://github.com/react-native-community/react-native-template-typescript
 *
 * @format
 */

import React, { useEffect } from 'react'
import { View, requireNativeComponent, NativeModules, Platform, DeviceEventEmitter } from "react-native"
import { WebView } from "react-native-webview"

const MyWebView = requireNativeComponent("MyWebView")
const { MyWebViewManager } = NativeModules

const App = () => {
  useEffect(() => {
    const onRedirect = (url: string) => {
      console.log(url)
    }
    
    DeviceEventEmitter.addListener("onRedirect", onRedirect)

    return () => {
      DeviceEventEmitter.removeListener("onRedirect", onRedirect)
    }
  }, [])

  if (Platform.OS === "android") {
    NativeModules.MyWebViewActivityStarter.openMyWebView("https://beanloop.se");
    return null;
  } else return (
    <View style={{ flex: 1 }}>
      <WebView
          nativeConfig={{
              component: MyWebView,
              props: {
                webViewURL: "https://beanloop.se",
                onRedirect: ({nativeEvent}: {nativeEvent: any}) => {
                  console.log(nativeEvent.url)
              },
              },
              viewManager: MyWebViewManager,
          }}
      />
  </View>
  )
}

export default App
