$('#confirmacaoExclusaoModal').on(
		'show.bs.modal',
		function(event) {
			var button = $(event.relatedTarget);
			var codigo = button.data('codigo');
			var descricao = button.data('descricao');

			var modal = $(this);
			var form = modal.find('form');
			var action = form.data('url-base');
			if (!action.endsWith('/')) {
				action += '/';
			}

			form.attr('action', action + codigo);

			modal.find('.modal-body span').html(
					'Tem certeza que deseja excluir o título <strong>'
							+ descricao + '</strong>?')

		});

$(function() {
	$('[rel="tooltip"]').tooltip();

	$('.valor-currency').maskMoney({
		decimal : ',',
		thousands : '.',
		allowZero : true,
		precision : 8
	});

	$('.js-atualizar-status').on('click', function(event) {
		event.preventDefault();

		var button = $(event.currentTarget);
		var urlReceber = button.attr('href');

		var response = $.ajax({
			url : urlReceber,
			type : 'PUT'
		});

		response.done(function(e) {
			var codigoTitulo = button.data('codigo');
			$('[data-role=' + codigoTitulo + ']').html('<span class="label label-success">' + e + '</span>');
			button.hide();
		});

		response.fail(function(e) {
			console.log(e);
			alert('Erro ao receber a cobrança');
		});

	});

});