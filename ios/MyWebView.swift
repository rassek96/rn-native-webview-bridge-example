//
//  MyWebView.swift
//  MyExampleApp
//
//  Created by Rasmus Karlsson on 2020-01-03.
//  Copyright © 2020 Facebook. All rights reserved.
//

import Foundation
import WebKit
import UIKit

@objc(MyWebViewManager)
class MyWebViewManager: RCTViewManager {
    override static func requiresMainQueueSetup() -> Bool {
        return true
    }

    override func view() -> UIView! {
        let mainView = MyWebView(frame: CGRect(
            origin: CGPoint(x: 0, y: 0),
            size: UIScreen.main.bounds.size
        ))
        return mainView
    }
}

@objc(MyWebView)
public class MyWebView: UIView, WKNavigationDelegate, WKUIDelegate {
    var webView: WKWebView!
    var webViewURL: NSString?
    @objc var onRedirect: RCTDirectEventBlock?

    @objc func setWebViewURL(_ val: NSString) {
        webViewURL = val
        
        if let url = URL(string: self.webViewURL as! String) {
            webView.load(URLRequest(url: url))
            webView.allowsBackForwardNavigationGestures = true
        }

        addSubview(webView)
    }

    public override init(frame: CGRect) {
        super.init(frame: frame)

        let configuration: WKWebViewConfiguration = WKWebViewConfiguration()
        webView = WKWebView(frame: frame, configuration: configuration)
      
        webView.uiDelegate = self
        webView.navigationDelegate = self
    }

    public required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
  
    public func webView(_ webView: WKWebView, decidePolicyFor navigationAction: WKNavigationAction, decisionHandler: (WKNavigationActionPolicy) -> Void) {
      onRedirect!(["url": navigationAction.request.url?.absoluteString ?? ""])
      decisionHandler(.allow)
    }
}
