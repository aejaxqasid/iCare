let patientTab = $("#patientSlotTable");
let pendingTab = $("#pendingSlotTable");
let acceptedTab = $("#acceptedSlotTable");
let rejectedTab = $("#rejectedSlotTable");
let cancelledTab = $("#cancelledSlotTable");

$(document).ready(function () {

  acceptedTab.hide();
  rejectedTab.hide();
  cancelledTab.hide();

  $("#selectId").change(function () {
    var selectVal = $("#selectId option:selected").val();
    if (selectVal === "PENDING") {
      $("table").hide();
      pendingTab.show();
    }
    if (selectVal === "ACCEPTED") {
      $("table").hide();
      acceptedTab.show();
    }
    if (selectVal === "REJECTED") {
      $("table").hide();
      rejectedTab.show();
    }
    if (selectVal === "CANCELLED") {
      $("table").hide();
      cancelledTab.show();
    }
  });
});
