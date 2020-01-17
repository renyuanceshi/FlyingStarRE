.class Lm/e/huyen2/doc$1;
.super Ljava/io/InputStream;
.source "doc.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lm/e/huyen2/doc;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lm/e/huyen2/doc;


# direct methods
.method constructor <init>(Lm/e/huyen2/doc;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lm/e/huyen2/doc$1;->this$0:Lm/e/huyen2/doc;

    .line 16
    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    return-void
.end method


# virtual methods
.method public read()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 21
    const/4 v0, 0x0

    return v0
.end method
