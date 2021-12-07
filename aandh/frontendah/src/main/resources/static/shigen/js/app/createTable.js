//create table function, takes tableParams([[fieldName, inputType [, selectParams(object) ]]...]) and tabledata
function createTable(tableParams, tabledata, destination){
	columns = [
    {field:"EditButton", formatter:formatterEditButton, cellClick:editButtonClick, headerSort:false, hozAlign:"center", resizable:false,width: 70},
    {field:"CancelButton", formatter:formatterCancelButton, cellClick:cancelButtonClick, headerSort:false, hozAlign:"center", resizable:false,width: 70},
    {field:"SaveButton", formatter:formatterSaveButton, cellClick:saveButtonClick, headerSort:false, hozAlign:"center", resizable:false,width: 70},
    {field:"DeleteButton", formatter:formatterDeleteButton, cellClick:deleteButtonClick, headerSort:false, hozAlign:"center", resizable:false,width: 70},
    {title: "No." ,formatter:"rownum", hozAlign:"center",width:60, headerClick: handleHeaderClick },
    // {title:"Name", field:"name", editor:"input",sorter:"string", width:200, editable: isEditable, headerClick:disableBtnsTimeout },
    // {title:"Progress", field:"progress", editor: "number",sorter:"number", formatter:"progress", editable: isEditable, headerClick:disableBtnsTimeout},
    // {title:"Gender", field:"gender", editor:"select", editorParams:{"male":"male","female":"female"}, sorter:"string", editable: isEditable, headerClick:disableBtnsTimeout},
    // {title:"Rating", field:"rating", editor:"star",formatter:"star", hozAlign:"center", editable: isEditable, headerClick:disableBtnsTimeout},
    // {title:"Favourite Color", field:"col", editor:"input", sorter:"string", editable: isEditable, headerClick:disableBtnsTimeout}
  ]
  for (let i=0; i < tableParams.length; i++){
    if (tableParams[i][1] === "select"){
      columns.push({
		  title: tableParams[i][0].charAt(0).toUpperCase()+ tableParams[i][0].slice(1),
		  field: tableParams[i][0],
      editor: `${tableParams[i][1]}`,
      editorParams: tableParams[i][2],
		  sorter: "string",
		  editable: isEditable,
		  headerClick: handleHeaderClick
	  })} else if (tableParams[i][1] === "input"){
      columns.push({
		  title: tableParams[i][0].charAt(0).toUpperCase()+ tableParams[i][0].slice(1),
		  field: tableParams[i][0],
		  editor: `${tableParams[i][1]}`,
		  sorter: "string",
		  editable: isEditable,
		  headerClick: handleHeaderClick
    })} else if (tableParams[i][1] === "number"){
      columns.push({
		  title: tableParams[i][0].charAt(0).toUpperCase()+ tableParams[i][0].slice(1),
		  field: tableParams[i][0],
		  editor: `${tableParams[i][1]}`,
		  sorter: "number",
		  editable: isEditable,
		  headerClick: handleHeaderClick
    })} else{
      console.log("....")
    }
  }

// make buttons appear disabled
function disableBtns(){
  $(".cancelBtn").css("opacity", 0.2);
  $(".saveBtn").css("opacity", 0.2);
  //var cancelBtns = document.getElementsByName('cancelBtn');
  // for (let i=0; i< cancelBtns.length; i++){
  //   cancelBtns[i].style.opacity = 0.2;
  // }
  // var saveBtns = document.getElementsByName('saveBtn');
  // for (let i=0; i< saveBtns.length; i++){
  //   saveBtns[i].style.opacity = 0.2;
  // }
  
}
//call function when user clicks on header
function handleHeaderClick(){
  setTimeout(function(){
    disableBtns();
    stylePagination();
  },0.1)  
}


//define data
// var tabledata = [
//     { id:1, name:"Oli Bob", progress:12, gender:"male", rating:1, col:"red", age:24 },
//     { id:2, name:"Mary May", progress:1, gender:"female", rating:2, col:"blue", age:24 },
//     { id:3, name:"Christine Lobowski", progress:42, gender:"female", rating:0, col:"green", age:24 },
//     { id:4, name:"Brendon Philips", progress:100, gender:"male", rating:1, col:"orange", age:24 },
//     { id:5, name:"Margret Marmajuke", progress:16, gender:"female", rating:5, col:"yellow", age:24},
// ];

// const editCheck = function(cell){
//     let position = cell.getRow().getPosition();
//     let data = cell.getValue();
//     return (position === tabledata.length -1 ) && (data === undefined || data === "") ;
// }

//create edit button
function formatterEditButton(cell, formatterParams){
    return "<div class='btn badge badge-pill badge-secondary'>Edit</div>";
}
//create cancel button
function formatterCancelButton(cell, formatterParams){
   return "<div id='cancelBtn' name='cancelBtn' class='cancelBtn btn badge badge-pill badge-warning'>Cancel</div>";
}
//create save button
function formatterSaveButton(cell, formatterParams){
   return "<div name='saveBtn' class='saveBtn btn badge badge-pill badge-success'>Save</div>";
}
//create delete button
function formatterDeleteButton(cell, formatterParams){
   return "<div class='btn badge badge-pill badge-danger'>Delete</div>";
}

//edit function
function editButtonClick(e, cell){
  currentRow = cell.getRow()
  currentTable = cell.getTable()
  selectedRows = currentTable.getSelectedRows()
    if (selectedRows.length == 0) {
      for (i = 0; i < selectedRows.length; i++) {
        selectedRows[i].deselect()
        selectedRows[i].reformat()
      }
      currentTable.deselectRow()
      currentRow.select()
      currentRow.reformat()

      cells = currentRow.getCells()
      for (i = 0; i < cells.length; i++) {
        cells[i].setValue(cells[i].getValue());
      }
    }
    currentRow.getCells()[5].edit();
    $("#reactivity-add").attr("disabled", true);
    $("#addToDb").attr("disabled", true);
    $("#reactivity-add").css("opacity", 0.2);
    $("#addToDb").css("opacity", 0.2);
    //stylePagination();
    //document.getElementById("reactivity-add").disabled = true;
    //document.getElementById("reactivity-add").style.opacity = 0.2;
  }
  
//cancel function
function cancelButtonClick(e, cell){
  if (!cell.getRow().isSelected()){
    return
  }
  currentRow = cell.getRow()
  currentTable = cell.getTable()
  if (cell.getRow().isSelected()){
    //Cancel
    cells = currentRow.getCells()
    for (i = 0; i < cells.length; i++) {
      cells[i].restoreOldValue();
    }
    stopEditing(cell);
  }
}

//save function
function saveButtonClick(e, cell){
  if (!cell.getRow().isSelected()){
    return
  }
  stopEditing(cell);
   $(dataSpan).remove();
  createDataInput();
  if(table.getPage() !== table.getPageMax()){
    table.nextPage();
    table.previousPage();
  }else{
    table.previousPage();
    table.nextPage();
  }
  
  
}

//delete function
function deleteButtonClick(e, cell){
  // if (!cell.getRow().isSelected()){
  //   return
  // }
  let rowIndex = cell.getRow().getPosition();

  let id = cell.getData().id;
  let index;
  for (let i=0; i< tabledata.length; i++){
    if (tabledata[i].id === id){
      index = i;
    }
  }
  //Can use prompt to make them confirm the name
  if(window.confirm("Delete Data No."+ (rowIndex+1))){
    stopEditing(cell);
    cell.getRow().delete();
    if (index > -1) {
      tabledata.splice(index, 1);
    }
  }
  stylePagination();
  disableBtns();
  $(dataSpan).remove();
  createDataInput();
}

//call this function whenever the user stops editing
function stopEditing(cell){
  currentRow = cell.getRow()
  currentTable = cell.getTable()
  currentTable.deselectRow()
  currentRow.reformat()
  disableBtns();
  $("#reactivity-add").attr("disabled", false);
  $("#reactivity-add").css("opacity", 1);
  $("#addToDb").attr("disabled", false);
  $("#addToDb").css("opacity", 1);
  //document.getElementById("reactivity-add").disabled = false;
  //document.getElementById("reactivity-add").style.opacity = 1;
}

//check if cell is editable
function isEditable(cell){
  return cell.getRow().isSelected()  
}
//cell.getValue() === null || cell.getValue() === ""


//Build Tabulator
var table = new Tabulator(`${destination}`, {
  data:tabledata,
  height:"100%",
  layout:"fitColumns",
  layoutColumnsOnNewData:true,
  pagination: "local",
  paginationSize: 10,
  paginationAddRow:"local",
  selectable: false,
  reactiveData:true,
  columns: columns,
  rowAdded: function(row){
    setTimeout(function(){
      currentRow = row;
      currentTable = row.getTable();
      selectedRows = currentTable.getSelectedRows();
      if (selectedRows.length == 0) {
        for (i = 0; i < selectedRows.length; i++) {
          selectedRows[i].deselect()
          selectedRows[i].reformat()
        }
        currentTable.deselectRow()
        currentRow.select()
        currentRow.reformat()
        cells = currentRow.getCells();
        for (i = 0; i < cells.length; i++) {
          cells[i].setValue(cells[i].getValue());
        }
      }
      row.getCells()[5].edit();
      $("#reactivity-add").attr("disabled", true);
      $("#reactivity-add").css("opacity", 0.2);
      $("#addToDb").attr("disabled", true);
      $("#addToDb").css("opacity", 0.2);
      stylePagination();
      
      
      //document.getElementById("reactivity-add").disabled = true;
      //document.getElementById("reactivity-add").style.opacity = 0.2;
    },0.1);
  },
  pageLoaded:function(pageno){
    //pageno - the number of the loaded page
    disableBtns();
    stylePagination();
    // checkIfLastPage();
    }
  // ,
  // cellClick: function(e, cell){
  //   if (cell.getValue() === null || cell.getValue() === ""){
  //     currentRow = cell.getRow()
  //     currentTable = cell.getTable()
  //     selectedRows = currentTable.getSelectedRows()
  //     if (selectedRows.length == 0) {
  //       for (i = 0; i < selectedRows.length; i++) {
  //         selectedRows[i].deselect()
  //         selectedRows[i].reformat()
  //       }
  //       currentTable.deselectRow()
  //       currentRow.select()
  //       currentRow.reformat()

  //       cells = currentRow.getCells()
  //       for (i = 0; i < cells.length; i++) {
  //         cells[i].setValue(cells[i].getValue());
  //       }
  //     }
  //     $("#reactivity-add").attr("disabled", true);
  //     $("#reactivity-add").css("opacity", 0.2);
      
  //   //document.getElementById("reactivity-add").disabled = true;
  //   //document.getElementById("reactivity-add").style.opacity = 0.2;
  //   }
  // }

});



//add row to bottom of table on button click
document.getElementById("reactivity-add").addEventListener("click", function(){
  //table.addRow({ id: tabledata[tabledata.length-1].id + 1, name:"User",age: 23, gender:"male", color:"black"});
  
  
  // table.setPageToRow(tabledata.length -1);
  tabledata.push({ id: tabledata[tabledata.length-1].id + 1, name:"User",age: 23, gender:"male", color:"black"});
  //table.previousPage();
  //table.nextPage();
  //table.nextPage();
 
  
   
});

//save data to DB
document.getElementById("addToDb").addEventListener("click", function(){
    //api call to save to db
    alert("Saved to database!");
});

function stylePagination(){
  $(".tabulator-footer").find("button").css({
  "margin-left": "0.35rem",
  "margin-right": "0.35rem",
  "background-color": "#dba0ac",
  "font-size":"1rem", 
  "color":"#ffffff" 
  })
}

//move pagination to the top of the table 
$(".tabulator-footer").prependTo(".table-div");

//styling pagination
$(".tabulator-footer").css({
  "margin-bottom": "0.5rem",
  "margin-top":"1rem",
  "display": "flex",
  "justify-content": "center",
  "background-color":"#dba0ac"
});
stylePagination();

let dataSpan;
//create input element to show number of data points
function createDataInput(){
  dataSpan = document.createElement("span");
  let dataText = document.createElement("p");
  dataText.innerText = "Total Data Points:";
  let dataInput = document.createElement("input");
  dataInput.setAttribute("disabled", true);
  $(dataInput).prependTo(dataSpan);
  $(dataText).prependTo(dataSpan);
  $(dataInput).val(tabledata.length);
  $(dataSpan).prependTo(".tabulator-footer");
}

function checkIfLastPage(){
  if(table.getPage() !== table.getPageMax()){
    $("#reactivity-add").attr("disabled", true);
    $("#reactivity-add").css("opacity", 0.2);
  }else{
    $("#reactivity-add").attr("disabled", false);
    $("#reactivity-add").css("opacity", 1);
  }
}


//when page loads
disableBtns();
createDataInput();
//checkIfLastPage();









// //add to tabledata
// document.getElementById("confirm").addEventListener("click", function(){
//     document.getElementById("confirm").style.display = "none";
//     document.getElementById("cancel").style.display = "none";
//     document.getElementById("reactivity-add").disabled= false;
//     document.getElementById("reactivity-delete").disabled = false;
// })


// document.getElementById("cancel").addEventListener("click", function(){
//     tabledata.pop();
//     document.getElementById("confirm").style.display = "none";
//     document.getElementById("cancel").style.display = "none";
//     document.getElementById("reactivity-add").disabled= false;
//     document.getElementById("reactivity-delete").disabled = false;
// })

// cellClick: function(e,cell){
    //         let position = cell.getRow().getPosition();
    //         let data = cell.getValue();
    //         // console.log(`position: ${position}`);
    //         // console.log(`tabledata.length: ${tabledata.length}`);
    //         console.log(position === tabledata.length -1)
    //         console.log(data === undefined);
    //         console.log(data);
    //         console.log("---------------")
    //     }
}
