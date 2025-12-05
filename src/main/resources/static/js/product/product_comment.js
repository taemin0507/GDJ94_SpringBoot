/**
 * 
 */
console.log("dsffsdfsdf");

const list = document.getElementById("list");
let num = list.getAttribute("data-product-num");

fetch(`./commentList?productNum=${num}`)
	.then(r => r.json())
	.then(r => {
		r.forEach(dto =>{
			let tr = document.createElement("tr") //<tr></tr>
			let td = document.createElement("td")//<td></td>
			td.innerText=dto.username;
			tr.append(td);
			td = document.createElement("td");
			td.innerText=dto.boardContents;
			tr.append(td);
			td = document.createElement("td");
			td.innerText=dto.boardDate;
			tr.append(td);
			list.append(tr);
		})
		
	})
	.catch(e => console.log(e))

;