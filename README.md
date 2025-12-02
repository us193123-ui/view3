## 概要
3キャラクターから自分と敵を選んで戦う、ターン制バトルゲームです。  
1ターンに「攻撃」か「回復」のどちらかを行えます。  
回復できる回数はキャラクターによって異なります。

ダメージは、キャラクターごとの攻撃力・防御力を元に計算された値の
0.8倍から1.2倍のランダムで決まります。

## 使用ソフト・SDK
- IntelliJ IDEA
- Eclipse Temurin JDK 17
- JavaFX 17.0.11

## 実行方法
1. GitHub のReleasesから View3.zip`をダウンロード
2. ZIP を解凍する
3. 解凍したView3フォルダをデスクトップなどに移動  
   （※ ZIP の中からは起動できません）
4. View3フォルダ内のアプリをダブルクリックして起動

## 開発の目的
Javaを学び始めて間もないですが以下のステップで段階的にスキルを学んできました
1. 基礎の学習
2. コンソールでのじゃんけんゲーム  
3. コンソールでのシンプルなターン制バトル  
4. 今回のJavaFXを使用したGUI付きバトルゲーム
「見た目も含めて完成度を高めたい」という思いでJavaFXに挑戦しました。

## ソースコード（src フォルダ）

スタート画面、選択画面、戦闘画面、勝敗画面（勝ち・負け）があり、  
SceneManager のメソッドでシーンを切り替えます。

各シーンには、そのシーンで使用する画像を読み込む **List クラス** があります。  
（例：StartScene と StartList）

---

###  戦闘処理
戦闘では、List とは別に以下のクラスを使用します。

- **GameManager**：戦闘全体の管理（攻撃・回復・敵ターン・勝敗判定など）
- **LegendAni**：各キャラのアニメーションに使用する値やフレームを管理します。
- **LegendUI**：UI アニメーションの管理（HPバー更新・ダメージ演出など）

---

###  BGM
- **BgmPlayer クラス**：シーンごとの BGM を選択・再生します。

---

###  キャラクター
キャラクターは Legendクラス（スーパークラス）を継承しています。

- Lifeline  
- Rev  
- Wraith  

---

## シーン構成図（簡易）

MyApp（メインクラス）

↓

SceneManager

↓

StartScene ← BgmPlayer ← StartList

↓

SelectScene ← BgmPlayer ← SelectList

↓

BattleScene ← BgmPlayer ← BattleList

↳ GameManager（戦闘の管理）

↳ LegendUI（UIアニメーション）

↓

WinScene ← BgmPlayer ← WinList
  /  LoseScene ← BgmPlayer ← LoseList
