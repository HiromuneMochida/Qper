/**
 * バリデーションチェック.
 */
const VALIDATE_EMAIL = '*emailを入力してください';
const VALIDATE_PASSWORD = '*passwordを入力してください';
const VALIDATE_TITLE = '*タイトルを入力してください';
const VALIDATE_CONTENT = '*投稿内容を入力してください';

$(function() {
  $('#loginForm').validate({
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

$(function() {
  $('#registForm').validate({
    rules: {
      title: {
        required: true,
      },
      content: {
        required: true,
      },
    },
    messages: {
      title: {
        required: VALIDATE_TITLE,
      },
      content: {
        required: VALIDATE_CONTENT,
      },
    },
  })
})

$(function() {
  $('#editForm').validate({
    rules: {
      title: {
        required: true,
      },
      content: {
        required: true,
      },
    },
    messages: {
      title: {
        required: VALIDATE_TITLE,
      },
      content: {
        required: VALIDATE_CONTENT,
      },
    },
  })
})