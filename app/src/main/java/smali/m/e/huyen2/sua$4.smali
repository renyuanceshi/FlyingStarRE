.class Lm/e/huyen2/sua$4;
.super Ljava/lang/Object;
.source "sua.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lm/e/huyen2/sua;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lm/e/huyen2/sua;


# direct methods
.method constructor <init>(Lm/e/huyen2/sua;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    .line 150
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 12
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v11, 0x0

    .line 157
    :try_start_0
    iget-object v8, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    iget-object v8, v8, Lm/e/huyen2/sua;->e2:Landroid/widget/EditText;

    invoke-virtual {v8}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-interface {v8}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v5

    .line 159
    .local v5, "na":Ljava/lang/String;
    if-eqz v5, :cond_0

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    const-string v9, ""

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 160
    :cond_0
    iget-object v8, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    const-string v9, "Please enter the name"

    const/4 v10, 0x0

    invoke-static {v8, v9, v10}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v8

    invoke-virtual {v8}, Landroid/widget/Toast;->show()V

    .line 245
    .end local v5    # "na":Ljava/lang/String;
    :goto_0
    return-void

    .line 164
    .restart local v5    # "na":Ljava/lang/String;
    :cond_1
    iget-object v8, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    const-string v9, "danhsach.txt"

    invoke-virtual {v8, v9}, Lm/e/huyen2/sua;->deleteFile(Ljava/lang/String;)Z

    .line 165
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, ", "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    iget-object v9, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    iget-object v9, v9, Lm/e/huyen2/sua;->giod:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " degrees, "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "period "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    iget-object v9, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    iget-object v9, v9, Lm/e/huyen2/sua;->giv:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 168
    .local v7, "sua":Ljava/lang/String;
    iget-object v8, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    iget-object v8, v8, Lm/e/huyen2/sua;->col:Ljava/util/ArrayList;

    iget-object v9, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    iget v9, v9, Lm/e/huyen2/sua;->x3:I

    invoke-virtual {v8, v9, v7}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 208
    :try_start_1
    iget-object v8, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    .line 209
    const-string v9, "danhsach.txt"

    const v10, 0x8000

    .line 208
    invoke-virtual {v8, v9, v10}, Lm/e/huyen2/sua;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v2

    .line 210
    .local v2, "fos":Ljava/io/FileOutputStream;
    new-instance v6, Ljava/io/OutputStreamWriter;

    invoke-direct {v6, v2}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    .line 212
    .local v6, "osw":Ljava/io/OutputStreamWriter;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    iget-object v8, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    iget-object v8, v8, Lm/e/huyen2/sua;->col:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v8

    if-lt v3, v8, :cond_2

    .line 215
    invoke-virtual {v6}, Ljava/io/OutputStreamWriter;->flush()V

    .line 216
    invoke-virtual {v6}, Ljava/io/OutputStreamWriter;->close()V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_0

    .line 224
    .end local v2    # "fos":Ljava/io/FileOutputStream;
    .end local v3    # "i":I
    .end local v6    # "osw":Ljava/io/OutputStreamWriter;
    :goto_2
    :try_start_2
    iget-object v8, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    const-string v9, "Data changed"

    .line 225
    const/4 v10, 0x0

    .line 224
    invoke-static {v8, v9, v10}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v8

    .line 225
    invoke-virtual {v8}, Landroid/widget/Toast;->show()V

    .line 226
    iget-object v8, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    invoke-virtual {v8}, Lm/e/huyen2/sua;->getIntent()Landroid/content/Intent;

    move-result-object v4

    .line 227
    .local v4, "in23":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 228
    .local v0, "bun33":Landroid/os/Bundle;
    const-string v8, "iz"

    iget-object v9, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    iget-object v9, v9, Lm/e/huyen2/sua;->col:Ljava/util/ArrayList;

    invoke-virtual {v0, v8, v9}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 229
    invoke-virtual {v4, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 230
    iget-object v8, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    const/4 v9, 0x3

    invoke-virtual {v8, v9, v4}, Lm/e/huyen2/sua;->setResult(ILandroid/content/Intent;)V

    .line 231
    iget-object v8, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    invoke-virtual {v8}, Lm/e/huyen2/sua;->finish()V
    :try_end_2
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_0

    .line 240
    .end local v0    # "bun33":Landroid/os/Bundle;
    .end local v4    # "in23":Landroid/content/Intent;
    .end local v5    # "na":Ljava/lang/String;
    .end local v7    # "sua":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 241
    .local v1, "e":Ljava/lang/NumberFormatException;
    iget-object v8, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    const-string v9, "N\u0103m nh\u1eadp v\u00e0o kh\u00f4ng h\u1ee3p l\u1ec7"

    invoke-static {v8, v9, v11}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v8

    invoke-virtual {v8}, Landroid/widget/Toast;->show()V

    .line 242
    invoke-virtual {v1}, Ljava/lang/NumberFormatException;->printStackTrace()V

    goto/16 :goto_0

    .line 213
    .end local v1    # "e":Ljava/lang/NumberFormatException;
    .restart local v2    # "fos":Ljava/io/FileOutputStream;
    .restart local v3    # "i":I
    .restart local v5    # "na":Ljava/lang/String;
    .restart local v6    # "osw":Ljava/io/OutputStreamWriter;
    .restart local v7    # "sua":Ljava/lang/String;
    :cond_2
    :try_start_3
    new-instance v9, Ljava/lang/StringBuilder;

    iget-object v8, p0, Lm/e/huyen2/sua$4;->this$0:Lm/e/huyen2/sua;

    iget-object v8, v8, Lm/e/huyen2/sua;->col:Ljava/util/ArrayList;

    invoke-virtual {v8, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v9, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v8, "\n"

    invoke-virtual {v9, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/io/OutputStreamWriter;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;
    :try_end_3
    .catch Ljava/io/FileNotFoundException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/lang/NumberFormatException; {:try_start_3 .. :try_end_3} :catch_0

    .line 212
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 217
    .end local v2    # "fos":Ljava/io/FileOutputStream;
    .end local v3    # "i":I
    .end local v6    # "osw":Ljava/io/OutputStreamWriter;
    :catch_1
    move-exception v1

    .line 219
    .local v1, "e":Ljava/io/FileNotFoundException;
    :try_start_4
    invoke-virtual {v1}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 220
    .end local v1    # "e":Ljava/io/FileNotFoundException;
    :catch_2
    move-exception v1

    .line 222
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_4
    .catch Ljava/lang/NumberFormatException; {:try_start_4 .. :try_end_4} :catch_0

    goto :goto_2
.end method
