$(document).ready(function () {
  //1. hide error section
  $("#fnameError").hide();
  $("#lnameError").hide();
  $("#emailError").hide();
  $("#specError").hide();
  $("#genderError").hide();
  $("#mobileError").hide();
  $("#addrError").hide();

  //2. set error variable
  var fnameError = false;
  var lnameError = false;
  var emailError = false;
  var specError = false;
  var genderError = false;
  var mobileError = false;
  var addrError = false;

  //3. validation function
  function validate_first_name() {
    let val = $("#firstName").val();
    let regex = /^[A-Za-z\s]*$/;
    if (val == "") {
      $("#fnameError").show();
      $("#fnameError").html("*<strong>Name</strong> is required");
      $("#fnameError").addClass("text-danger");
      fnameError = false;
    } else if (!regex.test(val)) {
      $("#fnameError").show();
      $("#fnameError").html(
        "*Only English Aphabets and white space are allowed"
      );
      $("#fnameError").addClass("text-danger");
      fnameError = false;
    } else {
      $("#fnameError").hide();
      fnameError = true;
    }
    return fnameError;
  }

  function validate_last_name() {
    let val = $("#lastName").val();
    let regex = /^[A-Za-z\s]*$/;
    if (val == "") {
      $("#lnameError").show();
      $("#lnameError").html("*<strong>Name</strong> is required");
      $("#lnameError").addClass("text-danger");
      lnameError = false;
    } else if (!regex.test(val)) {
      $("#lnameError").show();
      $("#lnameError").html(
        "*Only English Aphabets and white space are allowed"
      );
      $("#lnameError").addClass("text-danger");
      lnameError = false;
    } else {
      $("#lnameError").hide();
      lnameError = true;
    }
    return lnameError;
  }

  function validate_email() {
    let val = $("#email").val();
    let regex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9]+\.[A-Za-z]{2,4}$/;
    if (val == "") {
      $("#emailError").show();
      $("#emailError").html("*<strong>Email</strong> is required");
      $("#emailError").addClass("text-danger");
      emailError = false;
    } else if (!regex.test(val)) {
      $("#emailError").show();
      $("#emailError").html("*invalid email!");
      $("#emailError").addClass("text-danger");
      emailError = false;
    } else {
      $("#emailError").hide();
      emailError = true;
    }
    return emailError;
  }

  function validate_spec() {
    let val = $("#spec").val();
    if (val == "") {
      $("#specError").show();
      $("#specError").html("*<strong>Specialization</strong> is required");
      $("#specError").addClass("text-danger");
      specError = false;
    } else {
      specError = true;
      $("#specError").hide();
    }
    return specError;
  }

  function validate_gender() {
    let val = $("input[name='gender']:checked").val();
    if (val == undefined) {
      $("#genderError").show();
      $("#genderError").html("*<strong>Gender</strong> is required");
      $("#genderError").addClass("text-danger");
      genderError = false;
    } else {
      genderError = true;
      $("#genderError").hide();
    }
    return genderError;
  }

  function validate_mobile() {
    let val = $("#mobile").val();
    let regex = /^[6-9]\d{9}$/;
    if (val == "") {
      $("#mobileError").show();
      $("#mobileError").html("*<strong>Mobile Number</strong> is required");
      $("#mobileError").addClass("text-danger");
      mobileError = false;
    } else if (!regex.test(val)) {
      $("#mobileError").show();
      $("#mobileError").html("*invalid mobile number!");
      $("#mobileError").addClass("text-danger");
      mobileError = false;
    } else {
      $("#mobileError").hide();
      mobileError = true;
    }
    return mobileError;
  }

  function validate_addr() {
    var val = $("#addr").val();
    var regexp = /^[A-Za-z0-9\.\'\-\,\s]*$/;
    if (val == "") {
      $("#addrError").show();
      $("#addrError").html("*<strong>Address</strong> is required");
      $("#addrError").addClass("text-danger");
      addrError = false;
    } else if (!regexp.test(val)) {
      $("#addrError").show();
      $("#addrError").html("*invalid address!");
      $("#addrError").addClass("text-danger");
      addrError = false;
    } else {
      $("#addrError").hide();
      addrError = true;
    }
    return addrError;
  }

  //4. activation listener
  $("#firstName").keyup(function () {
    validate_first_name();
  });

  $("#lastName").keyup(function () {
    validate_last_name();
  });

  $("#email").keyup(function () {
    validate_email();
  });

  $("#spec").change(function () {
    validate_spec();
  });

  $("input[name='gender']").click(function () {
    validate_gender();
  });

  $("#mobile").keyup(function () {
    validate_mobile();
  });

  $("#addr").keyup(function () {
    validate_addr();
  });

  //5. validate
  $("#docForm").submit(function () {
    validate_first_name();
    validate_last_name();
    validate_email();
    validate_spec();
    validate_gender();
    validate_mobile();
    validate_addr();

    if (
      fnameError &&
      lnameError &&
      emailError &&
      specError &&
      genderError &&
      mobileError &&
      addrError
    )
      return true;
    else return false;
  });
});
