//-------------------------------------------
//20191230 s.toku
//-------------------------------------------
package mrs.app.reservation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import javax.validation.*;

/**
 * 予約フォームの開始時刻・終了時刻の制約を設定するインターフェース
 * @author shoheitokumaru
 *
 */
//javadoc 生成する時にいい感じにリンク効かせることができるみたい
@Documented
//このアノテーションで制約(チェック)したい具体的なロジックを記述したクラスを指定します
@Constraint(validatedBy = { ThirtyMinutesUnitValidator.class })
/*注釈型が適用可能なプログラム要素の種類を示します
 * ANNOTATION_TYPE : アノテーションに適用可 CONSTRUCTOR : コンストラクタに適用可 FIELD : フィールドに適用可
 * */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
/*アノテーションの読み込みタイミングを指定できます。
 * CLASS : コンパイル時にクラスファイルに記録される。実行時にVMに読み込まれない
 * RUNTIME : 実行時にVMに読み込まれる
 * SOURCE : コンパイル時に破棄 
 * */
@Retention(RetentionPolicy.RUNTIME)
//@interfaceを付与し、独自のアノテーションを作成します
public @interface ThirtyMinutesUnit {
	//不正入力時に警告(?)として出したいメッセージです
	String message() default "{mrs.app.reservation.ThirtyMinutesUtil.message}";
	//特定のバリデーショングループがカスタマイズできるような設定です
	Class<?>[]groups() default {};
	//チェック対象のオブジェクトになんらかのメタ情報を与えるためだけの宣言です
	Class<? extends Payload>[]payload() default {};
	
	@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	
	//ConstraintValidator　の実装に寄ってチェック可能な対象(複数可能)を定義します
	public @interface List {
		ThirtyMinutesUnit[]value();
	}
}
