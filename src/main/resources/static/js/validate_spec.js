$(document).ready(function () {

  //1. Hide error secton
  $("#codeError").hide();
  $("#nameError").hide();
  $("#descError").hide();

  //2. define error variable
  var codeError = false;
  var nameError = false;
  var descError = false;

  //3. define valdate function
  function validate_code() {
    var code = $("#code").val();
    var exp = /^[A-Z]{4,8}$/;
    if (code == "") {
      $("#codeError").show();
      $("#codeError").html("*<strong>CODE</strong> cannot be empty!");
      $("#codeError").addClass("text-danger");
      codeError = false;
    } else if (!exp.test(code)) {
      $("#codeError").show();
      $("#codeError").html(
        "*<strong>CODE</strong> must have 4 to 8 characters"
      );
      $("#codeError").addClass("text-danger");
      codeError = false;
    } else {
      $("#codeError").hide();
      codeError = true;
    }
    return codeError;
  }

  function validate_name() {
    var code = $("#name").val();
    var exp = /^[A-Za-z\s]{4,30}$/;
    if (code == "") {
      $("#nameError").show();
      $("#nameError").html("*<strong>NAME</strong> cannot be empty!");
      $("#nameError").addClass("text-danger");
      codeError = false;
    } else if (!exp.test(code)) {
      $("#nameError").show();
      $("#nameError").html(
        "*<strong>CODE</strong> must have 4 to 30 characters"
      );
      $("#nameError").addClass("text-danger");
      nameError = false;
    } else {
      $("#nameError").hide();
      nameError = true;
    }
    return nameError;
  }

  function validate_desc() {
    var desc = $("#desc").val();
    var exp = /^[A-Za-z\.\'\-\,\s]*$/;
    if (desc == "") {
      $("#descError").show();
      $("#descError").html("*<strong>DESCRIPTION</strong> cannot be empty!");
      $("#descError").addClass("text-danger");
      codeError = false;
    } else if (!exp.test(desc)) {
      $("#descError").show();
      $("#descError").html(
        "*<strong>DESCRIPTION</strong> must have 4 to 30 characters"
      );
      $("#descError").addClass("text-danger");
      descError = false;
    } else {
      $("#descError").hide();
      descError = true;
    }
    return descError;
  }

  //4. action event listener
  $("#code").keyup(function () {
    $(this).val($(this).val().toUpperCase());
    validate_code();
  });

  $("#name").keyup(function () {
    validate_name();
  });

  $("#desc").keyup(function () {
    validate_desc();
  });

  //5. validate
  $("#specForm").submit(function () {
    validate_code();
    validate_name();
    validate_desc();

    if (codeError && nameError && descError) return true;
    else return false;
  });
});
