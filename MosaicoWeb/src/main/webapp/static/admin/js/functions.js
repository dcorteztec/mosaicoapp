 $(function() {
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                //CKEDITOR.replace('editor1');
                //bootstrap WYSIHTML5 - text editor
                $(".textarea").wysihtml5();
            });
function AddMoreFile(tableID) {
	var qtdImagem = document.getElementById("qtd").value;
	qtdImagem++;
	document.getElementById("qtd").value = qtdImagem;
	if(qtdImagem <= 15){
		var table = document.getElementById(tableID);
		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);
		var col1 = row.insertCell(0);
		var colInput = document.createElement("input");
		colInput.type = "file";
		colInput.name = "files";
		col1.appendChild(colInput);
	}
}

