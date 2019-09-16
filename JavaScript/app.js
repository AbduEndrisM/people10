
    // window.onclick = loadData;
    $(function() {
        $('#load-data').click(e => {
            e.preventDefault();
            $.getJSON('customers.json', function (customer) {
                let data = '';
                $.each(customer, function (key, value) {
                    data += '<tr>';
                    data += '<td>' + value.id + '</td>';
                    data += '<td>' + value.first_name + '</td>';
                    data += '<td>' + value.last_name + '</td>';
                    data += '<td>' + value.email + '</td>';
                    data += '<td>' + value.latitude + '</td>';
                    data += '<td>' + value.longitude + '</td>';
                    data += '<td>' + value.ip + '</td>';
                    data += '<td>' + value.created_at + '</td>';
                    // data += '<td>' + value.updated_at + '</td>';
                    data += '</tr>';
                });

                $('#customer_table').append(data);
            });
        });
    });
