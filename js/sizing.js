$(document).ready(function() {
  sizeContent();
  $(window).resize(function() {
    sizeContent();
  })
});

function sizeContent() {
  $('#content').css({
    "top": $("#top_bar").height() + 20,
    "height": $(window).height() - $("#top_bar").height() - 30
  });
}
