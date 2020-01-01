//-------------------------------------------
//20191228 s.toku
//-------------------------------------------
package mrs.app.reservation;

import java.time.LocalTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * "@ThirtyMinutesUnit"アノテーションに対するチェック処理を実装したクラスです
 * ConstraintValidator<使うValidateInterface, 検証対象のType>
 * @author shoheitokumaru
 *
 */
public class ThirtyMinutesUnitValidator 
implements ConstraintValidator<ThirtyMinutesUnit, LocalTime> {
		//initialize はisValidが呼ばれるための初期化処理です
		@Override
		public void initialize(ThirtyMinutesUnit constraintAnnotation) {
		}
		
		/*isValid は実際のバリデーションロジックを実装します。
		 * パラメーターとして渡される <T> value が実際の検証対象のオブジェクトになります。
		*/
		@Override
		public boolean isValid(LocalTime value, ConstraintValidatorContext context) {
			//Nullの場合はこちらのメソッドでの検証はせず、他に委譲する
			if (value==null) {
				return true;
			}
			return value.getMinute() % 30 == 0;
	}
}
