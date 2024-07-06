// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "SmsRetriever",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "SmsRetriever",
            targets: ["smsPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "smsPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/smsPlugin"),
        .testTarget(
            name: "smsPluginTests",
            dependencies: ["smsPlugin"],
            path: "ios/Tests/smsPluginTests")
    ]
)