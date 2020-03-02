//
//  MyWebView.m
//  MyExampleApp
//
//  Created by Rasmus Karlsson on 2020-01-03.
//  Copyright © 2020 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <React/RCTBridgeModule.h>
#import <React/RCTViewManager.h>

@interface RCT_EXTERN_MODULE(MyWebViewManager, RCTViewManager)

RCT_EXPORT_VIEW_PROPERTY(webViewURL, NSString)
RCT_EXPORT_VIEW_PROPERTY(onRedirect, RCTDirectEventBlock)

@end
