$(document).ready(function () {
  $("#doctorError").hide();
  $("#dateError").hide();
  $("#slotsError").hide();
  $("#feeError").hide();
  $("detailsError").hide();

  let doctorError = false;
  let dateError = false;
  let slotsError = false;
  let feeError = false;
  let detailsError = false;

  function validate_doctor() {
    let val = $("#doctor").val();
    if (val === "") {
      $("#doctorError").show();
      $("#doctorError").html("*required");
      $("#doctorError").addClass("text-danger");
      doctorError = false;
    } else {
      doctorError = true;
      $("#doctorError").hide();
    }
    return doctorError;
  }

  function validate_date() {
    let val = $("#date").val();
    if (val === "") {
      $("#dateError").show();
      $("#dateError").html("*required");
      $("#dateError").addClass("text-danger");
      dateError = false;
    } else {
      dateError = true;
      $("#dateError").hide();
    }
    return dateError;
  }

  function validate_slots() {
    let val = $("#slots").val();
    let regex = /^[0-9]*$/;
    if (val === "") {
      $("#slotsError").show();
      $("#slotsError").html("*required");
      $("#slotsError").addClass("text-danger");
      slotsError = false;
    } else if (val <= 0) {
      $("#slotsError").show();
      $("#slotsError").html("*number must be greater than zero");
      $("#slotsError").addClass("text-danger");
      slotsError = false;
    } else if (isNaN(val)) {
      $("#slotsError").show();
      $("#slotsError").html("*only positive integers are allowed");
      $("#slotsError").addClass("text-danger");
      slotsError = false;
    } else if (!regex.test(val)) {
      $("#slotsError").show();
      $("#slotsError").html("*only positive integers are allowed");
      $("#slotsError").addClass("text-danger");
      slotsError = false;
    } else {
      slotsError = true;
      $("#slotsError").hide();
    }

    return slotsError;
  }

  function validate_details() {
    var val = $("#details").val();
    var regexp = /^[A-Za-z0-9\.\'\-\,\s]*$/;
    if (val == "") {
      $("#detailsError").show();
      $("#detailsError").html("*required");
      $("#detailsError").addClass("text-danger");
      detailsError = false;
    } else if (!regexp.test(val)) {
      $("#detailsError").show();
      $("#detailsError").html("*invalid details");
      $("#detailsError").addClass("text-danger");
      detailsError = false;
    } else {
      detailsError = true;
      $("#detailsError").hide();
    }
    return detailsError;
  }

  function validate_fee() {
    let val = $("#fee").val();
    if (val === "") {
      $("#feeError").show();
      $("#feeError").html("*required");
      $("#feeError").addClass("text-danger");
      feeError = false;
    } else if (val <= 0) {
      $("#feeError").show();
      $("#feeError").html("*fee must be greater than zero");
      $("#feeError").addClass("text-danger");
      feeError = false;
    } else if (isNaN(val)) {
      $("#feeError").show();
      $("#feeError").html("*only positive values are allowed");
      $("#feeError").addClass("text-danger");
      feeError = false;
    } else {
      feeError = true;
      $("#feeError").hide();
    }

    return feeError;
  }

  $("#doctor").change(function () {
    validate_doctor();
  });

  $("#date").change(function () {
    validate_date();
  });

  $("#slots").change(function () {
    validate_slots();
  });

  $("#details").change(function () {
    validate_details();
  });

  $("#fee").change(function () {
    validate_fee();
  });

  $("#appForm").submit(function () {
    validate_doctor();
    validate_date();
    validate_slots();
    validate_details();
    validate_fee();

    if (doctorError && dateError && slotsError && feeError && detailsError)
      return true;
    else return false;
  });
});
