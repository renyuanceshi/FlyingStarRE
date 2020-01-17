.class Lm/e/huyen2/danhsach$1;
.super Ljava/lang/Object;
.source "danhsach.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lm/e/huyen2/danhsach;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/widget/AdapterView$OnItemClickListener;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lm/e/huyen2/danhsach;


# direct methods
.method constructor <init>(Lm/e/huyen2/danhsach;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lm/e/huyen2/danhsach$1;->this$0:Lm/e/huyen2/danhsach;

    .line 101
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
    .param p2, "arg1"    # Landroid/view/View;
    .param p3, "arg2"    # I
    .param p4, "arg3"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 106
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    sput p3, Lm/e/huyen2/danhsach;->ag:I

    .line 108
    iget-object v0, p0, Lm/e/huyen2/danhsach$1;->this$0:Lm/e/huyen2/danhsach;

    const/4 v1, 0x1

    iput v1, v0, Lm/e/huyen2/danhsach;->dem:I

    .line 109
    iget-object v0, p0, Lm/e/huyen2/danhsach$1;->this$0:Lm/e/huyen2/danhsach;

    const-string v1, "danh2.txt"

    invoke-virtual {v0, v1}, Lm/e/huyen2/danhsach;->deleteFile(Ljava/lang/String;)Z

    .line 111
    return-void
.end method
