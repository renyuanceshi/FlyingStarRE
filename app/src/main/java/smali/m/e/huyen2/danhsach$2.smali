.class Lm/e/huyen2/danhsach$2;
.super Ljava/lang/Object;
.source "danhsach.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lm/e/huyen2/danhsach;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lm/e/huyen2/danhsach;


# direct methods
.method constructor <init>(Lm/e/huyen2/danhsach;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    .line 116
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 15
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 119
    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    iget v12, v12, Lm/e/huyen2/danhsach;->dem:I

    if-nez v12, :cond_0

    .line 120
    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    .line 121
    const-string v13, "Choose one house"

    const/4 v14, 0x0

    .line 120
    invoke-static {v12, v13, v14}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v12

    .line 122
    invoke-virtual {v12}, Landroid/widget/Toast;->show()V

    .line 180
    :goto_0
    return-void

    .line 124
    :cond_0
    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    const-string v13, "danhsach.txt"

    invoke-virtual {v12, v13}, Lm/e/huyen2/danhsach;->deleteFile(Ljava/lang/String;)Z

    .line 125
    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    invoke-static {v12}, Lm/e/huyen2/danhsach;->access$0(Lm/e/huyen2/danhsach;)Landroid/widget/ListView;

    move-result-object v12

    .line 126
    invoke-virtual {v12}, Landroid/widget/ListView;->getCheckedItemPositions()Landroid/util/SparseBooleanArray;

    move-result-object v2

    .line 127
    .local v2, "checked":Landroid/util/SparseBooleanArray;
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_1
    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    invoke-static {v12}, Lm/e/huyen2/danhsach;->access$0(Lm/e/huyen2/danhsach;)Landroid/widget/ListView;

    move-result-object v12

    invoke-virtual {v12}, Landroid/widget/ListView;->getCount()I

    move-result v12

    if-lt v6, v12, :cond_1

    .line 135
    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    invoke-static {v12}, Lm/e/huyen2/danhsach;->access$0(Lm/e/huyen2/danhsach;)Landroid/widget/ListView;

    move-result-object v12

    invoke-virtual {v12}, Landroid/widget/ListView;->clearChoices()V

    .line 138
    :try_start_0
    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    const-string v13, "danh2.txt"

    .line 139
    const v14, 0x8000

    .line 138
    invoke-virtual {v12, v13, v14}, Lm/e/huyen2/danhsach;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v4

    .line 140
    .local v4, "fos":Ljava/io/FileOutputStream;
    new-instance v10, Ljava/io/OutputStreamWriter;

    invoke-direct {v10, v4}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    .line 141
    .local v10, "osw":Ljava/io/OutputStreamWriter;
    const/4 v6, 0x0

    :goto_2
    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    iget-object v12, v12, Lm/e/huyen2/danhsach;->col:Ljava/util/ArrayList;

    invoke-virtual {v12}, Ljava/util/ArrayList;->size()I

    move-result v12

    if-lt v6, v12, :cond_3

    .line 144
    invoke-virtual {v10}, Ljava/io/OutputStreamWriter;->flush()V

    .line 145
    invoke-virtual {v10}, Ljava/io/OutputStreamWriter;->close()V

    .line 147
    const-string v9, ""

    .line 148
    .local v9, "line3":Ljava/lang/String;
    const-string v8, "danhsach.txt"

    .line 149
    .local v8, "inFile":Ljava/lang/String;
    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    const-string v13, "danh2.txt"

    invoke-virtual {v12, v13}, Lm/e/huyen2/danhsach;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;

    move-result-object v1

    .line 151
    .local v1, "In":Ljava/io/FileInputStream;
    new-instance v7, Ljava/io/InputStreamReader;

    invoke-direct {v7, v1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 152
    .local v7, "in3":Ljava/io/InputStreamReader;
    new-instance v0, Ljava/io/BufferedReader;

    invoke-direct {v0, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 154
    .local v0, "BR":Ljava/io/BufferedReader;
    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    .line 155
    const v13, 0x8000

    .line 154
    invoke-virtual {v12, v8, v13}, Lm/e/huyen2/danhsach;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v5

    .line 157
    .local v5, "fos2":Ljava/io/FileOutputStream;
    new-instance v11, Ljava/io/OutputStreamWriter;

    invoke-direct {v11, v5}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    .line 159
    .local v11, "osw2":Ljava/io/OutputStreamWriter;
    :goto_3
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v9

    if-nez v9, :cond_4

    .line 164
    invoke-virtual {v11}, Ljava/io/OutputStreamWriter;->close()V

    .line 165
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 175
    .end local v0    # "BR":Ljava/io/BufferedReader;
    .end local v1    # "In":Ljava/io/FileInputStream;
    .end local v4    # "fos":Ljava/io/FileOutputStream;
    .end local v5    # "fos2":Ljava/io/FileOutputStream;
    .end local v7    # "in3":Ljava/io/InputStreamReader;
    .end local v8    # "inFile":Ljava/lang/String;
    .end local v9    # "line3":Ljava/lang/String;
    .end local v10    # "osw":Ljava/io/OutputStreamWriter;
    .end local v11    # "osw2":Ljava/io/OutputStreamWriter;
    :goto_4
    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    const/4 v13, 0x0

    iput v13, v12, Lm/e/huyen2/danhsach;->dem:I

    .line 177
    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    const-string v13, "Data deleted"

    .line 178
    const/4 v14, 0x0

    .line 177
    invoke-static {v12, v13, v14}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v12

    .line 178
    invoke-virtual {v12}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 129
    :cond_1
    invoke-virtual {v2, v6}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 130
    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    iget-object v12, v12, Lm/e/huyen2/danhsach;->col:Ljava/util/ArrayList;

    invoke-virtual {v12, v6}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 133
    :cond_2
    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    invoke-static {v12}, Lm/e/huyen2/danhsach;->access$1(Lm/e/huyen2/danhsach;)Landroid/widget/ArrayAdapter;

    move-result-object v12

    invoke-virtual {v12}, Landroid/widget/ArrayAdapter;->notifyDataSetChanged()V

    .line 127
    add-int/lit8 v6, v6, 0x1

    goto/16 :goto_1

    .line 142
    .restart local v4    # "fos":Ljava/io/FileOutputStream;
    .restart local v10    # "osw":Ljava/io/OutputStreamWriter;
    :cond_3
    :try_start_1
    new-instance v13, Ljava/lang/StringBuilder;

    iget-object v12, p0, Lm/e/huyen2/danhsach$2;->this$0:Lm/e/huyen2/danhsach;

    iget-object v12, v12, Lm/e/huyen2/danhsach;->col:Ljava/util/ArrayList;

    invoke-virtual {v12, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v13, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v12, "\n"

    invoke-virtual {v13, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v10, v12}, Ljava/io/OutputStreamWriter;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 141
    add-int/lit8 v6, v6, 0x1

    goto/16 :goto_2

    .line 161
    .restart local v0    # "BR":Ljava/io/BufferedReader;
    .restart local v1    # "In":Ljava/io/FileInputStream;
    .restart local v5    # "fos2":Ljava/io/FileOutputStream;
    .restart local v7    # "in3":Ljava/io/InputStreamReader;
    .restart local v8    # "inFile":Ljava/lang/String;
    .restart local v9    # "line3":Ljava/lang/String;
    .restart local v11    # "osw2":Ljava/io/OutputStreamWriter;
    :cond_4
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v13

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v13, "\n"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/io/OutputStreamWriter;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 162
    invoke-virtual {v11}, Ljava/io/OutputStreamWriter;->flush()V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_3

    .line 167
    .end local v0    # "BR":Ljava/io/BufferedReader;
    .end local v1    # "In":Ljava/io/FileInputStream;
    .end local v4    # "fos":Ljava/io/FileOutputStream;
    .end local v5    # "fos2":Ljava/io/FileOutputStream;
    .end local v7    # "in3":Ljava/io/InputStreamReader;
    .end local v8    # "inFile":Ljava/lang/String;
    .end local v9    # "line3":Ljava/lang/String;
    .end local v10    # "osw":Ljava/io/OutputStreamWriter;
    .end local v11    # "osw2":Ljava/io/OutputStreamWriter;
    :catch_0
    move-exception v3

    .line 169
    .local v3, "e":Ljava/io/FileNotFoundException;
    invoke-virtual {v3}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 170
    .end local v3    # "e":Ljava/io/FileNotFoundException;
    :catch_1
    move-exception v3

    .line 172
    .local v3, "e":Ljava/io/IOException;
    invoke-virtual {v3}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4
.end method
