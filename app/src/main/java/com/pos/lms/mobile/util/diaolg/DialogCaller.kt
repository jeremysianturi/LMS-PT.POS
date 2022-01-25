package com.pos.lms.mobile.util.diaolg

import android.content.Context
import android.content.DialogInterface

object DialogCaller {

    fun showDialog(
        context: Context?,
        title: String?,
        message: String?,
        code: String,
        onClickListener: DialogInterface.OnClickListener?,
    ) {

        val dialog: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(context)
        dialog.setTitle(title)
        dialog.setMessage(message)
        dialog.setPositiveButton("Ok", onClickListener)
        dialog.setNegativeButton("Cancel", onClickListener)
        dialog.show()

    }
}