$(function () {
            console.log("ready to go");
    $(".delete").click(function () {
        console.log("Please help");

        var id =  $(".tableRow").attr("row_id");

        $.post('delete',{"idSelected":id},function (result) {
            $("#" + id).remove();
            }
        )
    })
    // remove
    // $("thead > th ").click(function () {
    //     var tablerows = $("tr");
    //     tablerows.each(function (index ) {
    //         if(this.attr("id")>tablerows[index].attr("id"))
    //         {
    //
    //         }
    //     })
    // })

    // })


    $(document).find('.btn_save').hide();

    $(document).on('focusout', '.row_data', function(event)
    {
        event.preventDefault();
        console.log("focus");
        if($(this).attr('edit_type') == 'button')
        {
            return false;
        }
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('row_id');

        //hide save and cacel buttons
        tbl_row.find('.btn_save').hide();


        //show edit button
        tbl_row.find('.btn_edit').show();

        //make the whole row editable
        tbl_row.find('.row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-secondary')
            .removeClass('text-white')
            .css('padding','');

        tbl_row.find('.row_data').each(function(index, val)
        {
            $(this).html( $(this).attr('original_entry') );
        })
    })
    $(document).on('click', '.btn_edit', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('row_id');

        tbl_row.find('.btn_save').show();


        //hide edit button
        tbl_row.find('.btn_edit').hide();

        //make the whole row editable
        tbl_row.find('.datas')
            .attr('contenteditable', 'true')
            .attr('edit_type', 'button')
            .addClass('bg-secondary text-white')
            .css('padding','3px')

        //--->add the original entry > start
        tbl_row.find('.row_data').each(function(index, val)
        {
            //this will help in case user decided to click on cancel button
            $(this).attr('original_entry', $(this).html());
        })
        //--->add the original entry > end

    })
    $(document).on('click', '.btn_save', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('row_id');


        //hide save and cacel buttons
        tbl_row.find('.btn_save').hide();
        tbl_row.find('.btn_cancel').hide();

        //show edit button
        tbl_row.find('.btn_edit').show();


        //make the whole row editable
        tbl_row.find('.datas')
            .attr('edit_type', 'click')
            .removeClass('bg-secondary text-white')
            .css('padding','')

        //--->get row data > start
        var arr = {};
        tbl_row.find('.row_data').each(function(index, val)
        {
            var col_name = $(this).attr('col_name');
            var col_val  =  $(this).html();
            arr[col_name] = col_val;
        });
        //--->get row data > end

        //use the "arr"	object for your ajax call
        $.extend(arr, {row_id:row_id});
        $.post('update',arr,function (result) {
                console.log(result);
            }
        )
        tbl_row.find('.row_data').each(function(index, val)
        {
            //this will help in case user decided to click on cancel button
            $(this).attr('original_entry', $(this).html());
        })




    })
})

