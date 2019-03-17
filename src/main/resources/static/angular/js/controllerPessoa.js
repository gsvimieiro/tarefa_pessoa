angular.module("PessoaApp", [])
	.value("urlBase", "http://localhost:8080/rest/")
	.controller("pessoaController", function($http, urlBase){	
	
	var self = this;
	self.projeto = "Cadastro pessoas com Angular 1";
	
	self.pessoa = undefined;
	self.pessoas = [];
	self.busca = undefined;
	
	self.novo = function(){
		// cria um objeto vazio
		self.pessoa = {};
		self.busca = undefined;
	};
	
	self.salvar = function(){
		var metodo = "POST";
		var rest = "save";
		
		// caso id preenchido, pessoa ja existe
		if (self.pessoa.id){
			metodo = "PUT";
			rest = "update";
		};		
		$http({
			method: metodo,
			url: urlBase + rest,
			data: self.pessoa
		}).then(function successCallback(response){
			self.atualizarTela();
		}, function errorCallback(response){
			self.ocorreuErro();
		});
	};
	
	self.alterar = function(dadosPessoa){
		self.busca = undefined;
		self.pessoa = dadosPessoa;
	};
	
	self.deletar = function(dadosPessoa){
		self.pessoa = dadosPessoa;
		
		$http({
			method:"DELETE",
			url: urlBase + "remove/" + self.pessoa.id,
			data: self.pessoa
		}).then(function successCallback(response){
			self.atualizarTela();			
		}, function errorCallback(response){
			self.ocorreuErro();
		});
	};
	
	
	self.pesquisar = function(dadosPessoa){
		self.pes = dadosPessoa;
		
		$http({
			method:"GET",
			url: urlBase + "pessoa/" + self.pes.id
		}).then(function successCallback(response){
			self.busca = response.data;
		}, function errorCallback(response){
			self.ocorreuErro();
		});
	};
	self.ocorreuErro = function(){
		alert("Erro encontrado ao salvar o registro");
	};
	
	self.atualizarTela = function(){
		$http({
			method:'GET',
			url: urlBase + 'pessoas'
		}).then(function successCallback(response){
			self.pessoas = response.data;
			self.pessoa = undefined;
			self.busca = undefined;
		}, function erroCallback(response){
			self.ocorreuErro();
		});

	};	
	
	self.iniciar = function(){
		self.atualizarTela();
	};
	
	self.voltar = function(){
		self.busca = undefined;
		self.atualizarTela();
	}
	
	self.iniciar();
});