$(function () {
    $('.excluir').on('click', function (e) {
    	e.preventDefault();
        let caminho = this.href;
        $('#modalExclusao').data('caminho', caminho);
        $('#modalExclusao').modal('show');
    });

    $('#btnExcluir').click(function(){
        let caminho = $('#modalExclusao').data('caminho');
        document.location.href =  caminho;
    });
})

