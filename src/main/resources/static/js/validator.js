/**
 * バリデーションチェック.
 */
const VALIDATE_EMAIL = 'emailを入力してください';
const VALIDATE_PASSWORD = 'passwordを入力してください';

$(function() {
  $('#login').validate({
    rules: {
      email: {
        required: true,
      },
      password: {
        required: true,
      },
    },
    messages: {
      email: {
        required: VALIDATE_EMAIL,
      },
      password: {
        required: VALIDATE_PASSWORD,
      },
    },
  })
})