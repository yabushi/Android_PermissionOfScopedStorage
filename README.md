Android10より導入されたScopedStorageでは、外部ストレージ内に存在するアプリ固有のファイルへのアクセス権限が強化された。
そのアクセス権について、検証した際のアプリをまとめた
セキュリティの観点で、他のアプリから自アプリのScopedStorageが参照可能かを検証した。

結論
- Android10以下では、ストレージへのアクセス権限を付与したアプリであれば、他のアプリのScopedStorageへの参照が許可される。
- Android11以降では、権限によらず、他のアプリのScopedStorageの内容は参照不可。

検証端末
- Android Studio Pixel3 エミュレータ

アプリ
- アプリ

条件
- 外部ストレージへのアクセス許可設定をしておく。
- 


- GooglePlayStoreのリリース制限
    - https://developer.android.com/google/play/requirements/target-sdk?hl=ja
    - PlayStoreにリリースする際は、ターゲットAPI Levelを34以上にする必要がある
    - ただし、PlayStoreにアップロードせずに組織内などのみで配布する場合には本制限の影響を受けない

