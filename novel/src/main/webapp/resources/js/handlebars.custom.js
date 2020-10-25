Handlebars.registerHelper('index', (x)=>{ return parseInt(x)+1; });
Handlebars.registerHelper('if', (v1, m, v2, options) => {
	switch (m) {
		case 'eq':{
			if (v1 == v2) {
				if (typeof options.inverse == 'undefined') {
					return true;
				}else{
					return options.fn(this);
				}
			}
		}
		case 'ge':{
			if (v1 >= v2) {
				if (typeof options.inverse == 'undefined') {
					return true;
				} else {
					return options.fn(this);
				}
			}
		}
		break;
		case 'le':{
			if (v1 <= v2) {
				if (typeof options.inverse == 'undefined') {
					return true;
				} else {
					return options.fn(this);
				}
			}
		}
		break;
		case 'gt':{
			if (v1 > v2) {
				if (typeof options.inverse == 'undefined') {
					return true;
				} else {
					return options.fn(this);
				}
			}
		}
		break;
		case 'lt':{
			if (v1 < v2) {
				if (typeof options.inverse == 'undefined') {
					return true;
				} else {
					return options.fn(this);
				}
			}
		}
		break;
		case 'ne':{
			if (v1 != v2) {
				if (typeof options.inverse == 'undefined') {
					return true;
				} else {
					return options.fn(this);
				}
			}
		}
		break;
		case 'or':{
			if (v1 || v2) {
				if (typeof options.inverse == 'undefined') {
					return true;
				} else {
					return options.fn(this);
				}
			}
		}
		break;
		case 'and':{
			if (v1 && v2) {
				if (typeof options.inverse == 'undefined') {
					return true;
				} else {
					return options.fn(this);
				}
			}
		}
		break;
	}
	if (typeof options.inverse == 'undefined') {
		return false;
	} else {
		return options.inverse(this);
	}
});